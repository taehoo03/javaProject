import { useEffect, useState } from 'react'
import axios from 'axios'

function ProductDetail({ setPage }) {
  const savedProduct = JSON.parse(
    localStorage.getItem('selectedProduct')
  )

  const [selectedProduct, setSelectedProduct] = useState(
    savedProduct || {
      category: '향수',
      name: '데일리 향수 세트',
      price: 39000,
      productId: 1,
      stock: 0
    }
  )

  const [loading, setLoading] = useState(true)

  useEffect(() => {
    loadProduct()
  }, [])

  const loadProduct = async () => {
    const productId =
      selectedProduct.productId || selectedProduct.id

    try {
      const response = await axios.get(
        'http://localhost:8080/api/products'
      )

      const product = response.data.find(
        (item) =>
          item.productId === productId
      )

      if (product) {
        const productData = {
          category: product.category,
          name: product.productName,
          price: product.price,
          productId: product.productId,
          stock: product.stock
        }

        setSelectedProduct(productData)

        localStorage.setItem(
          'selectedProduct',
          JSON.stringify(productData)
        )
      }
    } catch (error) {
      alert('상품 정보를 불러오지 못했습니다.')
    } finally {
      setLoading(false)
    }
  }

  const handleCart = async () => {
    const loginUser = JSON.parse(
      localStorage.getItem('loginUser')
    )

    if (!loginUser) {
      alert('로그인 후 장바구니를 이용할 수 있습니다.')
      setPage('login')
      return
    }

    if (selectedProduct.stock <= 0) {
      alert('품절된 상품입니다.')
      return
    }

    const productId =
      selectedProduct.productId || selectedProduct.id

    try {
      await axios.post(
        'http://localhost:8080/api/cart',
        {
          memberId: loginUser.memberId,
          productId,
          quantity: 1
        }
      )

      alert('장바구니에 상품이 담겼습니다.')
    } catch (error) {
      alert('장바구니에 상품을 담지 못했습니다.')
    }
  }

  const handleOrder = () => {
    if (selectedProduct.stock <= 0) {
      alert('품절된 상품입니다.')
      return
    }

    localStorage.setItem(
      'orderProduct',
      JSON.stringify(selectedProduct)
    )

    setPage('order')
  }

  if (loading) {
    return (
      <div className="product-detail-page">
        <div className="product-detail-info">
          <p>상품 정보를 불러오는 중입니다.</p>
        </div>
      </div>
    )
  }

  const isSoldOut =
    selectedProduct.stock <= 0

  return (
    <div className="product-detail-page">

      <div className="product-detail-image">
        상품 이미지
      </div>

      <div className="product-detail-info">

        <span>
          {selectedProduct.category}
        </span>

        <h2>
          {selectedProduct.name}
        </h2>

        <strong>
          {selectedProduct.price.toLocaleString()}원
        </strong>

        <p>
          친구에게 선물하기 좋은 상품입니다.
        </p>

        {isSoldOut ? (
          <p>
            품절
          </p>
        ) : (
          <p>
            재고 {selectedProduct.stock}개
          </p>
        )}

        <button
          onClick={handleCart}
          disabled={isSoldOut}
        >
          {isSoldOut
            ? '품절'
            : '장바구니 담기'}
        </button>

        <button
          onClick={handleOrder}
          disabled={isSoldOut}
        >
          {isSoldOut
            ? '품절'
            : '이 상품으로 선물하기'}
        </button>

        <button
          className="back-button"
          onClick={() => setPage('recommend')}
        >
          추천 상품으로 돌아가기
        </button>

      </div>

    </div>
  )
}

export default ProductDetail