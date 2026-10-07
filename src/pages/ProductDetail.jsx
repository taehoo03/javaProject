function ProductDetail({ setPage }) {
  return (
    <div className="product-detail-page">

      <button
        className="back-button"
        onClick={() => setPage('recommend')}
      >
        추천 상품으로 돌아가기
      </button>


      <div className="product-detail">

        <div className="product-detail-image">
          상품 이미지
        </div>


        <div className="product-detail-info">

          <span>향수</span>

          <h2>데일리 향수 세트</h2>

          <strong>39,000원</strong>

          <p>
            일상에서 부담 없이 사용할 수 있는 향수 세트입니다.
            선물용으로 적합한 구성으로 준비했습니다.
          </p>


          <div className="detail-line">
            <span>상품 종류</span>
            <strong>향수 세트</strong>
          </div>

          <div className="detail-line">
            <span>가격</span>
            <strong>39,000원</strong>
          </div>

          <div className="detail-line">
            <span>배송</span>
            <strong>무료 배송</strong>
          </div>


          <button
            className="order-button"
            onClick={() => setPage('order')}
          >
            이 상품으로 선물하기
          </button>

        </div>

      </div>

    </div>
  )
}

export default ProductDetail