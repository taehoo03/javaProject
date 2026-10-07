import { useState } from 'react'

function ProductManage() {
  const [products, setProducts] = useState([
    {
      id: 1,
      name: '데일리 향수 세트',
      category: '향수',
      price: 39000,
      stock: 20
    },
    {
      id: 2,
      name: '감성 데스크 소품 세트',
      category: '소품',
      price: 28000,
      stock: 15
    },
    {
      id: 3,
      name: '베스트셀러 도서 세트',
      category: '책',
      price: 25000,
      stock: 30
    }
  ])

  const [name, setName] = useState('')
  const [category, setCategory] = useState('')
  const [price, setPrice] = useState('')
  const [stock, setStock] = useState('')
  const [editId, setEditId] = useState(null)

  const handleSubmit = () => {
    if (!name || !category || !price || !stock) {
      alert('상품 정보를 모두 입력해주세요.')
      return
    }

    if (editId) {
      setProducts(
        products.map((product) =>
          product.id === editId
            ? {
                ...product,
                name,
                category,
                price: Number(price),
                stock: Number(stock)
              }
            : product
        )
      )

      alert('상품이 수정되었습니다.')
      setEditId(null)
    } else {
      const newProduct = {
        id: Date.now(),
        name,
        category,
        price: Number(price),
        stock: Number(stock)
      }

      setProducts([...products, newProduct])

      alert('상품이 등록되었습니다.')
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

  const handleDelete = (id) => {
    const result = window.confirm('이 상품을 삭제하시겠습니까?')

    if (!result) {
      return
    }

    setProducts(
      products.filter((product) => product.id !== id)
    )
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
              <span>{product.stock}개</span>

              <div className="table-buttons">

                <button
                  onClick={() => handleEdit(product)}
                >
                  수정
                </button>

                <button
                  onClick={() => handleDelete(product.id)}
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