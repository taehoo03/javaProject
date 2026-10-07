import { useEffect, useState } from 'react'
import axios from 'axios'

function Cart({ setPage }) {
  const [cart, setCart] = useState([])
  const [loading, setLoading] = useState(true)

  const loginUser = JSON.parse(
    localStorage.getItem('loginUser')
  )

  const memberId = loginUser?.memberId

  useEffect(() => {
    if (memberId) {
      loadCart()
    } else {
      setLoading(false)
    }
  }, [memberId])

  const loadCart = async () => {
    try {
      const response = await axios.get(
        'http://localhost:8080/api/cart',
        {
          params: {
            memberId
          }
        }
      )

      const cartData = response.data.map((item) => ({
        id: item.cartId,
        productId: item.productId,
        quantity: item.quantity
      }))

      const productResponse = await axios.get(
        'http://localhost:8080/api/products'
      )

      const products = productResponse.data

      const result = cartData.map((item) => {
        const product = products.find(
          (product) =>
            product.productId === item.productId
        )

        return {
          ...item,
          category: product
            ? product.category
            : '',
          name: product
            ? product.productName
            : '상품 정보 없음',
          price: product
            ? product.price
            : 0,
          stock: product
            ? product.stock
            : 0
        }
      })

      setCart(result)
    } catch (error) {
      alert('장바구니를 불러오지 못했습니다.')
    } finally {
      setLoading(false)
    }
  }

  const changeQuantity = async (id, amount) => {
    const item = cart.find(
      (item) => item.id === id
    )

    if (!item) {
      return
    }

    const newQuantity = Math.max(
      1,
      item.quantity + amount
    )

    try {
      await axios.put(
        'http://localhost:8080/api/cart',
        {
          cartId: item.id,
          memberId,
          productId: item.productId,
          quantity: newQuantity
        }
      )

      await loadCart()
    } catch (error) {
      alert('수량 변경에 실패했습니다.')
    }
  }

  const removeItem = async (id) => {
    try {
      await axios.delete(
        'http://localhost:8080/api/cart',
        {
          params: {
            cartId: id
          }
        }
      )

      await loadCart()
    } catch (error) {
      alert('상품 삭제에 실패했습니다.')
    }
  }

  const handleOrder = async () => {
    try {
      const response = await axios.get(
        'http://localhost:8080/api/products'
      )

      const products = response.data

      for (const item of cart) {
        const product = products.find(
          (product) =>
            product.productId === item.productId
        )

        if (!product) {
          alert('상품 정보를 찾을 수 없습니다.')
          return
        }

        if (product.stock === 0) {
          alert(
            `${product.productName}은(는) 품절된 상품입니다.`
          )
          return
        }

        if (product.stock < item.quantity) {
          alert(
            `${product.productName}은(는) 현재 재고가 ${product.stock}개 남아있어 ${item.quantity}개를 주문할 수 없습니다.`
          )
          return
        }
      }

      const orderProducts = cart.map((item) => ({
        productId: item.productId,
        category: item.category,
        name: item.name,
        price: item.price,
        quantity: item.quantity
      }))

      localStorage.setItem(
        'orderProducts',
        JSON.stringify(orderProducts)
      )

      setPage('order')
    } catch (error) {
      alert('재고를 확인하지 못했습니다.')
    }
  }

  const totalPrice = cart.reduce(
    (total, item) =>
      total + item.price * item.quantity,
    0
  )

  if (loading) {
    return (
      <div className="cart-page">
        <div className="cart-title">
          <h2>장바구니</h2>
          <p>장바구니를 불러오는 중입니다.</p>
        </div>
      </div>
    )
  }

  if (!memberId) {
    return (
      <div className="cart-page">

        <div className="cart-title">
          <h2>장바구니</h2>
          <p>
            로그인 후 장바구니를 이용할 수 있습니다.
          </p>
        </div>

        <div className="empty-cart">
          <h3>로그인이 필요해요.</h3>
          <p>로그인 후 장바구니를 확인해주세요.</p>

          <button
            onClick={() => setPage('login')}
          >
            로그인
          </button>
        </div>

      </div>
    )
  }

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

          <button
            onClick={() => setPage('recommend')}
          >
            추천 상품 보기
          </button>
        </div>
      ) : (
        <>

          <div className="cart-list">

            {cart.map((item) => (
              <div
                className="cart-item"
                key={item.id}
              >

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
                    onClick={() =>
                      changeQuantity(
                        item.id,
                        -1
                      )
                    }
                  >
                    -
                  </button>

                  <span>{item.quantity}</span>

                  <button
                    onClick={() =>
                      changeQuantity(
                        item.id,
                        1
                      )
                    }
                  >
                    +
                  </button>

                </div>

                <strong className="item-price">
                  {(
                    item.price * item.quantity
                  ).toLocaleString()}원
                </strong>

                <button
                  className="remove-button"
                  onClick={() =>
                    removeItem(item.id)
                  }
                >
                  삭제
                </button>

              </div>
            ))}

          </div>

          <div className="cart-summary">

            <div>
              <span>상품 금액</span>

              <strong>
                {totalPrice.toLocaleString()}원
              </strong>
            </div>

            <div>
              <span>배송비</span>

              <strong>무료</strong>
            </div>

            <div className="total-price">
              <span>총 결제 금액</span>

              <strong>
                {totalPrice.toLocaleString()}원
              </strong>
            </div>

            <button onClick={handleOrder}>
              {totalPrice.toLocaleString()}원 주문하기
            </button>

          </div>

        </>
      )}

    </div>
  )
}

export default Cart