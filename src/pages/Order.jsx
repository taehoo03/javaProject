import { useState } from 'react'

function Order({ setPage }) {
  const [name, setName] = useState('')
  const [phone, setPhone] = useState('')
  const [address, setAddress] = useState('')
  const [detailAddress, setDetailAddress] = useState('')
  const [message, setMessage] = useState('')
  const [payment, setPayment] = useState('card')

  const product = {
    name: '데일리 향수 세트',
    price: 39000,
    quantity: 1
  }

  const handleOrder = () => {
    if (!name || !phone || !address) {
      alert('배송 정보를 입력해주세요.')
      return
    }

    alert('주문이 완료되었습니다.')
    setPage('home')
  }

  return (
    <div className="order-page">

      <div className="order-title">
        <h2>주문하기</h2>
        <p>배송 정보를 확인하고 주문해주세요.</p>
      </div>

      <div className="order-content">

        <section className="order-section">

          <h3>배송 정보</h3>

          <div className="order-form">

            <label>받는 사람</label>

            <input
              type="text"
              value={name}
              onChange={(e) => setName(e.target.value)}
              placeholder="받는 사람 이름"
            />

            <label>전화번호</label>

            <input
              type="text"
              value={phone}
              onChange={(e) => setPhone(e.target.value)}
              placeholder="전화번호"
            />

            <label>주소</label>

            <input
              type="text"
              value={address}
              onChange={(e) => setAddress(e.target.value)}
              placeholder="주소"
            />

            <label>상세주소</label>

            <input
              type="text"
              value={detailAddress}
              onChange={(e) => setDetailAddress(e.target.value)}
              placeholder="상세주소"
            />

            <label>배송 메시지</label>

            <input
              type="text"
              value={message}
              onChange={(e) => setMessage(e.target.value)}
              placeholder="배송 메시지를 입력해주세요."
            />

          </div>

        </section>

        <section className="order-section">

          <h3>주문 상품</h3>

          <div className="order-product">

            <div className="order-product-image">
              상품 이미지
            </div>

            <div className="order-product-info">
              <h4>{product.name}</h4>
              <span>수량 {product.quantity}개</span>
              <strong>
                {product.price.toLocaleString()}원
              </strong>
            </div>

          </div>

        </section>

        <section className="order-section">

          <h3>결제 방법</h3>

          <div className="payment-list">

            <label>
              <input
                type="radio"
                value="card"
                checked={payment === 'card'}
                onChange={(e) => setPayment(e.target.value)}
              />
              신용카드
            </label>

            <label>
              <input
                type="radio"
                value="kakao"
                checked={payment === 'kakao'}
                onChange={(e) => setPayment(e.target.value)}
              />
              카카오페이
            </label>

            <label>
              <input
                type="radio"
                value="bank"
                checked={payment === 'bank'}
                onChange={(e) => setPayment(e.target.value)}
              />
              무통장입금
            </label>

          </div>

        </section>

        <section className="order-summary">

          <div>
            <span>상품 금액</span>
            <strong>39,000원</strong>
          </div>

          <div>
            <span>배송비</span>
            <strong>무료</strong>
          </div>

          <div className="order-total">
            <span>총 결제 금액</span>
            <strong>39,000원</strong>
          </div>

          <button onClick={handleOrder}>
            39,000원 결제하기
          </button>

          <button
            className="order-back-button"
            onClick={() => setPage('cart')}
          >
            장바구니로 돌아가기
          </button>

        </section>

      </div>

    </div>
  )
}

export default Order