import { useState } from 'react'

function Cart({ setPage }) {
  const [cart, setCart] = useState([
    {
      id: 1,
      name: '데일리 향수 세트',
      price: 39000,
      quantity: 1
    },
    {
      id: 2,
      name: '감성 데스크 소품 세트',
      price: 28000,
      quantity: 1
    }
  ])

  const changeQuantity = (id, amount) => {
    setCart(
      cart.map((item) =>
        item.id === id
          ? {
              ...item,
              quantity: Math.max(1, item.quantity + amount)
            }
          : item
      )
    )
  }

  const removeItem = (id) => {
    setCart(
      cart.filter((item) => item.id !== id)
    )
  }

  const totalPrice = cart.reduce(
    (total, item) => total + item.price * item.quantity,
    0
  )

  return (
    <div className="cart-page">

      <div className="cart-title">
        <h2>장바구니</h2>
        <p>선물할 상품을 확인해주세요.</p>
      </div>

      {cart.length === 0 ? (
        <div className="empty-cart">
          <h3>장바구니가 비어있어요.</h3>
          <p>마음에 드는 선물을 담아보세요.</p>

          <button onClick={() => setPage('recommend')}>
            추천 상품 보기
          </button>
        </div>
      ) : (
        <>

          <div className="cart-list">

            {cart.map((item) => (
              <div className="cart-item" key={item.id}>

                <div className="cart-item-image">
                  상품 이미지
                </div>

                <div className="cart-item-info">
                  <h3>{item.name}</h3>
                  <strong>
                    {item.price.toLocaleString()}원
                  </strong>
                </div>

                <div className="quantity">

                  <button
                    onClick={() => changeQuantity(item.id, -1)}
                  >
                    -
                  </button>

                  <span>{item.quantity}</span>

                  <button
                    onClick={() => changeQuantity(item.id, 1)}
                  >
                    +
                  </button>

                </div>

                <strong className="item-price">
                  {(item.price * item.quantity).toLocaleString()}원
                </strong>

                <button
                  className="remove-button"
                  onClick={() => removeItem(item.id)}
                >
                  삭제
                </button>

              </div>
            ))}

          </div>

          <div className="cart-summary">

            <div>
              <span>상품 금액</span>
              <strong>{totalPrice.toLocaleString()}원</strong>
            </div>

            <div>
              <span>배송비</span>
              <strong>무료</strong>
            </div>

            <div className="total-price">
              <span>총 결제 금액</span>
              <strong>{totalPrice.toLocaleString()}원</strong>
            </div>

            <button
              onClick={() => setPage('order')}
            >
              주문하기
            </button>

          </div>

        </>
      )}

    </div>
  )
}

export default Cart