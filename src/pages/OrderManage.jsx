import { useState } from 'react'

function OrderManage() {
  const [orders, setOrders] = useState([
    {
      id: 1001,
      name: '김하늘',
      product: '데일리 향수 세트',
      price: 39000,
      date: '2026-10-01',
      status: '주문접수'
    },
    {
      id: 1002,
      name: '박지민',
      product: '감성 데스크 소품 세트',
      price: 28000,
      date: '2026-10-02',
      status: '배송준비'
    },
    {
      id: 1003,
      name: '이서준',
      product: '베스트셀러 도서 세트',
      price: 25000,
      date: '2026-10-03',
      status: '배송중'
    }
  ])

  const changeStatus = (id, status) => {
    setOrders(
      orders.map((order) =>
        order.id === id
          ? {
              ...order,
              status
            }
          : order
      )
    )
  }

  const handleDelete = (id) => {
    const result = window.confirm(
      '이 주문을 삭제하시겠습니까?'
    )

    if (!result) {
      return
    }

    setOrders(
      orders.filter((order) => order.id !== id)
    )
  }

  return (
    <div className="order-manage-page">

      <div className="manage-title">
        <div>
          <h2>주문관리</h2>
          <p>회원의 주문 내역과 주문 상태를 관리할 수 있습니다.</p>
        </div>
      </div>

      <div className="order-manage-summary">
        <span>전체 주문</span>
        <strong>{orders.length}건</strong>
      </div>

      <div className="order-manage-table">

        <div className="order-table-header">
          <span>주문번호</span>
          <span>주문자</span>
          <span>상품</span>
          <span>금액</span>
          <span>주문일</span>
          <span>상태</span>
          <span>관리</span>
        </div>

        {orders.map((order) => (
          <div
            className="order-table-row"
            key={order.id}
          >
            <span>{order.id}</span>

            <span>{order.name}</span>

            <span>{order.product}</span>

            <span>
              {order.price.toLocaleString()}원
            </span>

            <span>{order.date}</span>

            <select
              value={order.status}
              onChange={(e) =>
                changeStatus(
                  order.id,
                  e.target.value
                )
              }
            >
              <option value="주문접수">
                주문접수
              </option>

              <option value="배송준비">
                배송준비
              </option>

              <option value="배송중">
                배송중
              </option>

              <option value="배송완료">
                배송완료
              </option>

              <option value="주문취소">
                주문취소
              </option>
            </select>

            <button
              onClick={() => handleDelete(order.id)}
            >
              삭제
            </button>
          </div>
        ))}

      </div>

    </div>
  )
}

export default OrderManage