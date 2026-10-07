import { useEffect, useState } from 'react'
import axios from 'axios'

function OrderManage() {
  const [orders, setOrders] = useState([])
  const [filter, setFilter] = useState('전체')

  useEffect(() => {
    loadOrders()
  }, [])

  const loadOrders = async () => {
    try {
      const memberResponse = await axios.get(
        'http://localhost:8080/api/members'
      )

      const productResponse = await axios.get(
        'http://localhost:8080/api/products'
      )

      const members = memberResponse.data
      const products = productResponse.data

      const allOrders = []

      for (const member of members) {
        const orderResponse = await axios.get(
          'http://localhost:8080/api/orders',
          {
            params: {
              memberId: member.memberId
            }
          }
        )

        orderResponse.data.forEach((order) => {
          const product = products.find(
            (product) =>
              product.productId === order.productId
          )

          allOrders.push({
            ...order,
            name: member.name,
            productName: product
              ? product.productName
              : '상품 정보 없음',
            category: product
              ? product.category
              : '',
            price: order.totalPrice,
            payment: order.paymentMethod,
            status:
              order.orderStatus === '주문완료'
                ? '주문 접수'
                : order.orderStatus
          })
        })
      }

      setOrders(allOrders)
    } catch (error) {
      alert('주문 데이터를 불러오지 못했습니다.')
    }
  }

  const handleStatusChange = async (
    orderId,
    status
  ) => {
    try {
      await axios.put(
        'http://localhost:8080/api/orders',
        {
          orderId,
          orderStatus: status
        }
      )

      await loadOrders()
    } catch (error) {
      alert('주문 상태 변경에 실패했습니다.')
    }
  }

  const handleDelete = async (orderId) => {
    const result = window.confirm(
      '이 주문을 삭제하시겠습니까?'
    )

    if (!result) {
      return
    }

    try {
      await axios.delete(
        'http://localhost:8080/api/orders',
        {
          params: {
            orderId
          }
        }
      )

      alert('주문이 삭제되었습니다.')

      await loadOrders()
    } catch (error) {
      alert('주문 삭제에 실패했습니다.')
    }
  }

  const filteredOrders =
    filter === '전체'
      ? orders
      : orders.filter(
          (order) => order.status === filter
        )

  const receivedCount = orders.filter(
    (order) => order.status === '주문 접수'
  ).length

  const preparingCount = orders.filter(
    (order) => order.status === '상품 준비중'
  ).length

  const shippingCount = orders.filter(
    (order) => order.status === '배송중'
  ).length

  const completedCount = orders.filter(
    (order) => order.status === '배송 완료'
  ).length

  return (
    <div className="order-manage-page">

      <div className="order-manage-header">

        <div>
          <h2>주문관리</h2>

          <p>
            전체 주문을 확인하고 배송 상태를 관리할 수 있습니다.
          </p>
        </div>

      </div>

      <div className="order-stat-list">

        <div className="order-stat-card">

          <span>전체 주문</span>

          <strong>
            {orders.length}
          </strong>

          <small>
            등록된 전체 주문
          </small>

        </div>

        <div className="order-stat-card">

          <span>주문 접수</span>

          <strong>
            {receivedCount}
          </strong>

          <small>
            확인이 필요한 주문
          </small>

        </div>

        <div className="order-stat-card">

          <span>배송중</span>

          <strong>
            {shippingCount}
          </strong>

          <small>
            현재 배송중인 주문
          </small>

        </div>

        <div className="order-stat-card">

          <span>배송 완료</span>

          <strong>
            {completedCount}
          </strong>

          <small>
            배송이 완료된 주문
          </small>

        </div>

      </div>

      <div className="order-manage-content">

        <div className="order-manage-toolbar">

          <div>

            <h3>주문 목록</h3>

            <span>
              총 {filteredOrders.length}건
            </span>

          </div>

          <select
            value={filter}
            onChange={(e) =>
              setFilter(e.target.value)
            }
          >
            <option>전체</option>
            <option>주문 접수</option>
            <option>상품 준비중</option>
            <option>배송중</option>
            <option>배송 완료</option>
          </select>

        </div>

        {filteredOrders.length === 0 ? (
          <div className="order-empty">

            <strong>
              주문이 없습니다.
            </strong>

            <p>
              선택한 상태의 주문이 없습니다.
            </p>

          </div>
        ) : (
          <div className="order-table">

            <div className="order-table-header">

              <span>주문번호</span>
              <span>상품</span>
              <span>받는 사람</span>
              <span>금액</span>
              <span>결제방법</span>
              <span>상태</span>
              <span>관리</span>

            </div>

            {filteredOrders.map(
              (order, index) => (

                <div
                  className="order-table-row"
                  key={order.orderId}
                >

                  <span className="order-number">
                    #{index + 1}
                  </span>

                  <div className="order-product-cell">

                    <strong>
                      {order.productName}
                    </strong>

                    <span>
                      {order.category}
                    </span>

                  </div>

                  <span>
                    {order.name}
                  </span>

                  <strong>
                    {order.price.toLocaleString()}원
                  </strong>

                  <span>
                    {order.payment}
                  </span>

                  <select
                    className="order-status-select"
                    value={order.status}
                    onChange={(e) =>
                      handleStatusChange(
                        order.orderId,
                        e.target.value
                      )
                    }
                  >
                    <option>주문 접수</option>
                    <option>상품 준비중</option>
                    <option>배송중</option>
                    <option>배송 완료</option>
                  </select>

                  <button
                    className="order-delete-button"
                    onClick={() =>
                      handleDelete(
                        order.orderId
                      )
                    }
                  >
                    삭제
                  </button>

                </div>

              )
            )}

          </div>
        )}

      </div>

    </div>
  )
}

export default OrderManage