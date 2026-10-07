import { useState } from 'react'
import axios from 'axios'

function Order({ setPage }) {
  const savedProducts = JSON.parse(
    localStorage.getItem('orderProducts')
  )

  const oldProduct = JSON.parse(
    localStorage.getItem('orderProduct')
  )

  const loginUser = JSON.parse(
    localStorage.getItem('loginUser')
  )

  const selectedFriend = JSON.parse(
    localStorage.getItem('selectedFriend')
  )

  const orderProducts =
    savedProducts && savedProducts.length > 0
      ? savedProducts
      : oldProduct
        ? [
            {
              ...oldProduct,
              quantity: oldProduct.quantity || 1
            }
          ]
        : [
            {
              category: '향수',
              name: '데일리 향수 세트',
              price: 39000,
              productId: 1,
              quantity: 1
            }
          ]

  const [name, setName] = useState(
    selectedFriend
      ? selectedFriend.name
      : loginUser
        ? loginUser.name
        : ''
  )

  const [phone, setPhone] = useState('')

  const [address, setAddress] = useState(
    loginUser ? loginUser.address : ''
  )

  const [detailAddress, setDetailAddress] = useState(
    loginUser ? loginUser.detailAddress : ''
  )

  const [payment, setPayment] = useState(
    '카드 결제'
  )

  const totalPrice = orderProducts.reduce(
    (total, product) =>
      total + product.price * product.quantity,
    0
  )

  const handleOrder = async () => {
    if (!loginUser) {
      alert('로그인 후 주문할 수 있습니다.')
      setPage('login')
      return
    }

    if (!selectedFriend) {
      alert('선물을 받을 친구를 선택해주세요.')
      setPage('friends')
      return
    }

    if (!name || !phone || !address) {
      alert('배송 정보를 모두 입력해주세요.')
      return
    }

    try {
      for (const product of orderProducts) {
        const productId =
          product.productId || product.id

        await axios.post(
          'http://localhost:8080/api/orders',
          {
            memberId: loginUser.memberId,
            receiverId: selectedFriend.memberId,
            productId,
            quantity: product.quantity,
            totalPrice:
              product.price * product.quantity,
            address,
            detailAddress,
            paymentMethod: payment
          }
        )
      }

      alert('주문이 완료되었습니다.')

      localStorage.removeItem(
        'orderProducts'
      )

      localStorage.removeItem(
        'orderProduct'
      )

      localStorage.removeItem(
        'selectedFriend'
      )

      setPage('home')
    } catch (error) {
      const message =
        error.response?.data?.message ||
        error.response?.data?.detail ||
        '주문에 실패했습니다.'

      alert(message)
    }
  }

  return (
    <div className="order-page">

      <div className="order-title">
        <div>
          <span>ORDER</span>
          <h2>주문하기</h2>
          <p>
            선물할 상품과 배송 정보를 확인해주세요.
          </p>
        </div>
      </div>

      <div className="order-layout">

        <div className="order-main">

          <section className="order-section">

            <div className="order-section-title">
              <h3>주문 상품</h3>
              <span>
                {orderProducts.length}개 상품
              </span>
            </div>

            <div className="order-product-list">

              {orderProducts.map(
                (product, index) => (
                  <div
                    className="order-product-card"
                    key={index}
                  >

                    <div className="order-product-image">
                      상품 이미지
                    </div>

                    <div className="order-product-detail">

                      <span>
                        {product.category}
                      </span>

                      <h4>
                        {product.name}
                      </h4>

                      <p>
                        수량 {product.quantity}개
                      </p>

                    </div>

                    <strong>
                      {(
                        product.price *
                        product.quantity
                      ).toLocaleString()}원
                    </strong>

                  </div>
                )
              )}

            </div>

          </section>

          <section className="order-section">

            <div className="order-section-title">
              <h3>배송 정보</h3>
              <span>필수 입력</span>
            </div>

            <div className="order-form">

              <div className="order-input-group">
                <label>받는 사람</label>

                <input
                  type="text"
                  value={name}
                  onChange={(e) =>
                    setName(e.target.value)
                  }
                  placeholder="받는 사람 이름"
                />
              </div>

              <div className="order-input-group">
                <label>전화번호</label>

                <input
                  type="text"
                  value={phone}
                  onChange={(e) =>
                    setPhone(e.target.value)
                  }
                  placeholder="전화번호"
                />
              </div>

              <div className="order-input-group">
                <label>주소</label>

                <input
                  type="text"
                  value={address}
                  onChange={(e) =>
                    setAddress(e.target.value)
                  }
                  placeholder="주소"
                />
              </div>

              <div className="order-input-group">
                <label>상세주소</label>

                <input
                  type="text"
                  value={detailAddress}
                  onChange={(e) =>
                    setDetailAddress(e.target.value)
                  }
                  placeholder="상세주소"
                />
              </div>

            </div>

          </section>

          <section className="order-section">

            <div className="order-section-title">
              <h3>결제 방법</h3>
              <span>결제수단 선택</span>
            </div>

            <div className="order-payment-list">

              <label
                className={
                  payment === '카드 결제'
                    ? 'payment-option selected'
                    : 'payment-option'
                }
              >
                <input
                  type="radio"
                  name="payment"
                  value="카드 결제"
                  checked={
                    payment === '카드 결제'
                  }
                  onChange={(e) =>
                    setPayment(e.target.value)
                  }
                />

                <span>카드 결제</span>
              </label>

              <label
                className={
                  payment === '카카오페이'
                    ? 'payment-option selected'
                    : 'payment-option'
                }
              >
                <input
                  type="radio"
                  name="payment"
                  value="카카오페이"
                  checked={
                    payment === '카카오페이'
                  }
                  onChange={(e) =>
                    setPayment(e.target.value)
                  }
                />

                <span>카카오페이</span>
              </label>

              <label
                className={
                  payment === '네이버페이'
                    ? 'payment-option selected'
                    : 'payment-option'
                }
              >
                <input
                  type="radio"
                  name="payment"
                  value="네이버페이"
                  checked={
                    payment === '네이버페이'
                  }
                  onChange={(e) =>
                    setPayment(e.target.value)
                  }
                />

                <span>네이버페이</span>
              </label>

            </div>

          </section>

        </div>

        <div className="order-sidebar">

          <div className="order-summary">

            <h3>결제 금액</h3>

            <div className="summary-row">
              <span>상품 금액</span>
              <strong>
                {totalPrice.toLocaleString()}원
              </strong>
            </div>

            <div className="summary-row">
              <span>배송비</span>
              <strong>무료</strong>
            </div>

            <div className="summary-total">
              <span>총 결제금액</span>

              <strong>
                {totalPrice.toLocaleString()}원
              </strong>
            </div>

            <button
              className="order-submit-button"
              onClick={handleOrder}
            >
              {totalPrice.toLocaleString()}원 결제하기
            </button>

            <button
              className="order-back-button"
              onClick={() => setPage('cart')}
            >
              장바구니로 돌아가기
            </button>

          </div>

        </div>

      </div>

    </div>
  )
}

export default Order