import { useEffect, useState } from 'react'
import axios from 'axios'

function ProductManage() {
  const [products, setProducts] = useState([])

  const [name, setName] = useState('')
  const [category, setCategory] = useState('')
  const [price, setPrice] = useState('')
  const [stock, setStock] = useState('')
  const [editId, setEditId] = useState(null)

  useEffect(() => {
    loadProducts()
  }, [])

  const loadProducts = async () => {
    try {
      const response = await axios.get(
        'http://localhost:8080/api/products'
      )

      const productData = response.data.map((product) => ({
        id: product.productId,
        name: product.productName,
        category: product.category,
        price: product.price,
        stock: product.stock
      }))

      setProducts(productData)
    } catch (error) {
      alert('상품 데이터를 불러오지 못했습니다.')
    }
  }

  const handleSubmit = async () => {
    if (!name || !category || !price || stock === '') {
      alert('상품 정보를 모두 입력해주세요.')
      return
    }

    if (Number(price) < 0 || Number(stock) < 0) {
      alert('가격과 재고는 0 이상으로 입력해주세요.')
      return
    }

    if (editId) {
      try {
        await axios.put(
          'http://localhost:8080/api/products',
          {
            productId: editId,
            productName: name,
            category,
            price: Number(price),
            stock: Number(stock)
          }
        )

        alert('상품이 수정되었습니다.')

        await loadProducts()

        setEditId(null)
      } catch (error) {
        alert('상품 수정에 실패했습니다.')
        return
      }
    } else {
      try {
        await axios.post(
          'http://localhost:8080/api/products',
          {
            productName: name,
            category,
            price: Number(price),
            stock: Number(stock)
          }
        )

        alert('상품이 등록되었습니다.')

        await loadProducts()
      } catch (error) {
        alert('상품 등록에 실패했습니다.')
        return
      }
    }

    setName('')
    setCategory('')
    setPrice('')
    setStock('')
  }

  const handleEdit = (product) => {
    setEditId(product.id)
    setName(product.name)
    setCategory(product.category)
    setPrice(product.price)
    setStock(product.stock)
  }

  const handleDelete = async (id) => {
    const result = window.confirm(
      '이 상품을 삭제하시겠습니까?'
    )

    if (!result) {
      return
    }

    try {
      await axios.delete(
        'http://localhost:8080/api/products',
        {
          params: {
            productId: id
          }
        }
      )

      alert('상품이 삭제되었습니다.')

      await loadProducts()
    } catch (error) {
      alert('상품 삭제에 실패했습니다.')
    }
  }

  return (
    <div className="product-manage-page">

      <div className="manage-title">
        <div>
          <h2>상품관리</h2>
          <p>등록된 상품을 관리할 수 있습니다.</p>
        </div>
      </div>

      <div className="product-form">

        <h3>
          {editId ? '상품 수정' : '상품 등록'}
        </h3>

        <div className="form-row">

          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="상품명"
          />

          <input
            type="text"
            value={category}
            onChange={(e) => setCategory(e.target.value)}
            placeholder="카테고리"
          />

          <input
            type="number"
            value={price}
            onChange={(e) => setPrice(e.target.value)}
            placeholder="가격"
          />

          <input
            type="number"
            value={stock}
            onChange={(e) => setStock(e.target.value)}
            placeholder="재고"
            min="0"
          />

          <button onClick={handleSubmit}>
            {editId ? '수정하기' : '상품 등록'}
          </button>

        </div>

      </div>

      <div className="manage-list">

        <div className="manage-list-title">
          <h3>상품 목록</h3>
          <span>총 {products.length}개</span>
        </div>

        <div className="product-table">

          <div className="table-header">
            <span>상품명</span>
            <span>카테고리</span>
            <span>가격</span>
            <span>재고</span>
            <span>관리</span>
          </div>

          {products.map((product) => (
            <div
              className="table-row"
              key={product.id}
            >

              <span>{product.name}</span>

              <span>{product.category}</span>

              <span>
                {product.price.toLocaleString()}원
              </span>

              <span>
                {product.stock === 0
                  ? '품절'
                  : `${product.stock}개`}
              </span>

              <div className="table-buttons">

                <button
                  onClick={() => handleEdit(product)}
                >
                  수정
                </button>

                <button
                  onClick={() =>
                    handleDelete(product.id)
                  }
                >
                  삭제
                </button>

              </div>

            </div>
          ))}

        </div>

      </div>

    </div>
  )
}

export default ProductManage