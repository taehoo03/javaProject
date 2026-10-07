import { useState } from 'react'
import axios from 'axios'

function SpringTest() {
  const [products, setProducts] = useState([])
  const [message, setMessage] = useState('')

  const handleTest = async () => {
    try {
      const response = await axios.get(
        'http://localhost:8080/api/products'
      )

      setProducts(response.data)
      setMessage('DB 상품 데이터 가져오기 성공!')
    } catch (error) {
      setMessage('DB 상품 데이터 가져오기 실패')
    }
  }

  return (
    <div className="friends-page">

      <div className="friends-title">
        <div>
          <h2>DB 상품 데이터 테스트</h2>
          <p>
            Oracle DB에 저장된 상품을 Spring 서버에서 가져옵니다.
          </p>
        </div>
      </div>

      <div className="friend-detail">

        <button onClick={handleTest}>
          DB 상품 가져오기
        </button>

        {message && (
          <p>
            {message}
          </p>
        )}

        {products.length > 0 && (
          <div>
            {products.map((product) => (
              <div key={product.productId}>
                <p>상품번호: {product.productId}</p>
                <p>카테고리: {product.category}</p>
                <p>상품명: {product.productName}</p>
                <p>설명: {product.description}</p>
                <p>가격: {product.price.toLocaleString()}원</p>
                <p>재고: {product.stock}개</p>
                <hr />
              </div>
            ))}
          </div>
        )}

      </div>

    </div>
  )
}

export default SpringTest