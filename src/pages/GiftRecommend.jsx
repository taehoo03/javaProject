import { useEffect, useState } from 'react'
import axios from 'axios'

function GiftRecommend({ setPage }) {
  const [friend, setFriend] = useState(null)
  const [products, setProducts] = useState([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    loadData()
  }, [])

  const loadData = async () => {
    try {
      const savedFriend = JSON.parse(
        localStorage.getItem('selectedFriend')
      )

      if (!savedFriend) {
        setLoading(false)
        return
      }

      setFriend(savedFriend)

      const response = await axios.get(
        'http://localhost:8080/api/products'
      )

      const productData = response.data

      const interest = savedFriend.interest || ''
      const favorite = savedFriend.favorite || ''
      const gift = savedFriend.gift || ''

      const keywords = [
        ...interest.split(','),
        ...favorite.split(','),
        ...gift.split(',')
      ]
        .map((keyword) => keyword.trim())
        .filter((keyword) => keyword)

      const scoredProducts = productData.map(
        (product) => {
          let score = 0

          const text = (
            product.category +
            ' ' +
            product.productName +
            ' ' +
            (product.description || '')
          ).toLowerCase()

          keywords.forEach((keyword) => {
            if (
              text.includes(keyword.toLowerCase())
            ) {
              score += 1
            }
          })

          return {
            ...product,
            score
          }
        }
      )

      scoredProducts.sort(
        (a, b) => {
          if (
            a.stock === 0 &&
            b.stock > 0
          ) {
            return 1
          }

          if (
            a.stock > 0 &&
            b.stock === 0
          ) {
            return -1
          }

          return b.score - a.score
        }
      )

      setProducts(scoredProducts)
    } catch (error) {
      alert('추천 상품을 불러오지 못했습니다.')
    } finally {
      setLoading(false)
    }
  }

  const handleProductClick = (product) => {
    const selectedProduct = {
      productId: product.productId,
      id: product.productId,
      category: product.category,
      name: product.productName,
      price: product.price,
      description: product.description,
      stock: product.stock
    }

    localStorage.setItem(
      'selectedProduct',
      JSON.stringify(selectedProduct)
    )

    setPage('product')
  }

  const handleBack = () => {
    setPage('friends')
  }

  if (loading) {
    return (
      <div className="recommend-page">
        <h2>추천 상품을 불러오는 중입니다.</h2>
      </div>
    )
  }

  if (!friend) {
    return (
      <div className="recommend-page">

        <div className="recommend-title">
          <h2>선물 추천</h2>
          <span>
            먼저 친구를 선택해주세요.
          </span>
        </div>

        <button
          className="back-button"
          onClick={handleBack}
        >
          친구 목록으로
        </button>

      </div>
    )
  }

  return (
    <div className="recommend-page">

      <div className="recommend-title">
        <p>선물 추천</p>

        <h2>
          {friend.name}님을 위한 선물
        </h2>

        <span>
          친구의 취향을 기준으로 상품을 추천합니다.
        </span>
      </div>

      <div className="recommend-info">

        <strong>
          {friend.name}님의 취향
        </strong>

        <div className="tag-list">

          <span>
            관심사: {friend.interest}
          </span>

          <span>
            좋아하는 것: {friend.favorite}
          </span>

          <span>
            받고 싶은 선물: {friend.gift}
          </span>

        </div>

      </div>

      <div className="product-section">

        <div className="section-title">
          <h2>추천 상품</h2>

          <span>
            총 {products.length}개
          </span>
        </div>

        <div className="product-list">

          {products.map((product) => {

            const isSoldOut =
              product.stock <= 0

            return (
              <div
                className={`product-card ${
                  isSoldOut
                    ? 'sold-out'
                    : ''
                }`}
                key={product.productId}
                onClick={() =>
                  handleProductClick(product)
                }
              >

                <div className="product-image">
                  상품 이미지
                </div>

                <div className="product-info">

                  <span>
                    {product.category}
                  </span>

                  <h3>
                    {product.productName}
                  </h3>

                  <strong>
                    {product.price.toLocaleString()}원
                  </strong>

                  <p>
                    {isSoldOut
                      ? '품절'
                      : `재고 ${product.stock}개`}
                  </p>

                </div>

              </div>
            )
          })}

        </div>

      </div>

      <button
        className="back-button"
        onClick={handleBack}
      >
        친구 목록으로
      </button>

    </div>
  )
}

export default GiftRecommend