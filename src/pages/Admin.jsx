function Admin({ setPage }) {
  return (
    <div className="admin-page">

      <div className="admin-title">
        <div>
          <span>ADMIN</span>
          <h2>관리자모드</h2>
          <p>뭐든 서비스의 상품, 회원, 주문을 관리합니다.</p>
        </div>
      </div>

      <div className="admin-stats">

        <div className="admin-stat">
          <span>전체 상품</span>
          <strong>3</strong>
          <small>등록된 상품</small>
        </div>

        <div className="admin-stat">
          <span>전체 회원</span>
          <strong>2</strong>
          <small>가입한 회원</small>
        </div>

        <div className="admin-stat">
          <span>전체 주문</span>
          <strong>3</strong>
          <small>접수된 주문</small>
        </div>

      </div>

      <div className="admin-section">

        <div className="admin-section-title">
          <h3>관리 메뉴</h3>
          <span>원하는 메뉴를 선택하세요.</span>
        </div>

        <div className="admin-menu">

          <div
            className="admin-card"
            onClick={() => setPage('productManage')}
          >
            <div className="admin-card-number">
              01
            </div>

            <div className="admin-card-content">
              <h3>상품관리</h3>
              <p>
                상품을 등록하고 수정하거나
                <br />
                삭제할 수 있습니다.
              </p>
            </div>

            <span className="admin-arrow">
              →
            </span>
          </div>

          <div
            className="admin-card"
            onClick={() => setPage('memberManage')}
          >
            <div className="admin-card-number">
              02
            </div>

            <div className="admin-card-content">
              <h3>회원관리</h3>
              <p>
                가입한 회원의 정보를 확인하고
                <br />
                관리할 수 있습니다.
              </p>
            </div>

            <span className="admin-arrow">
              →
            </span>
          </div>

          <div
            className="admin-card"
            onClick={() => setPage('orderManage')}
          >
            <div className="admin-card-number">
              03
            </div>

            <div className="admin-card-content">
              <h3>주문관리</h3>
              <p>
                주문 내역을 확인하고
                <br />
                배송 상태를 관리할 수 있습니다.
              </p>
            </div>

            <span className="admin-arrow">
              →
            </span>
          </div>

        </div>

      </div>

      <div className="admin-notice">

        <div>
          <strong>관리자 안내</strong>
          <p>
            상품과 회원, 주문 정보를 확인하고 관리할 수 있습니다.
          </p>
        </div>

        <button onClick={() => setPage('home')}>
          일반 화면으로 이동
        </button>

      </div>

    </div>
  )
}

export default Admin