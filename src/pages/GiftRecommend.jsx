import { useState } from 'react'

function GiftRecommend({ setPage }) {
  const savedPreference = JSON.parse(
    localStorage.getItem('preference')
  )

  const [products] = useState([
    {
      id: 1,
      category: '향수',
      name: '데일리 향수 세트',
      price: 39000
    },
    {
      id: 2,
      category: '소품',
      name: '감성 데스크 소품 세트',
      price: 28000
    },
    {
      id: 3,
      category: '책',
      name: '베스트셀러 도서 세트',
      price: 25000
    },
    {
      id: 4,
      category: '카페',
      name: '카페 기프트 카드',
      price: 30000
    },
    {
      id: 5,
      category: '여행',
      name: '여행용 파우치 세트',
      price: 32000
    },
    {
      id: 6,
      category: '음악',
      name: '블루투스 스피커',
      price: 45000
    }
  ])

  const preferenceList = savedPreference
    ? [
        ...savedPreference.interest.split(','),
        ...savedPreference.favorite.split(','),
        ...savedPreference.gift.split(',')
      ].map((item) => item.trim())
    : []

  const recommendedProducts = products.filter((product) =>
    preferenceList.includes(product.category)
  )

  const otherProducts = products.filter(
    (product) =>
      !preferenceList.includes(product.category)
  )

  const sortedProducts = [
    ...recommendedProducts,
    ...otherProducts
  ]

  return (
    <div className="recommend-page">

      <div className="recommend-title">

        <p>김하늘에게 선물하기</p>

        <h2>
          김하늘의 취향에 맞는 선물을 찾아봤어요.
        </h2>

        <span>
          등록된 취향을 참고해서 선물하기 좋은 상품을 추천합니다.
        </span>

      </div>

      <div className="recommend-info">

        <strong>김하늘의 취향</strong>

        {savedPreference ? (
          <div className="tag-list">

            {preferenceList.map((item, index) => (
              <span key={index}>
                {item}
              </span>
            ))}

          </div>
        ) : (
          <p>
            아직 등록된 취향이 없습니다.
          </p>
        )}

      </div>

      <div className="product-section">

        <div className="section-title">

          <h2>추천 상품</h2>

          <span>
            총 {products.length}개의 상품
          </span>

        </div>

        <div className="product-list">

          {sortedProducts.map((product) => {

            const isRecommended =
              preferenceList.includes(product.category)

            return (
              <div
                className="product-card"
                key={product.id}
                onClick={() => setPage('product')}
              >

                <div className="product-image">
                  상품 이미지
                </div>

                <div className="product-info">

                  <span>
                    {product.category}
                  </span>

                  <h3>
                    {product.name}
                  </h3>

                  <strong>
                    {product.price.toLocaleString()}원
                  </strong>

                  {isRecommended && (
                    <p>
                      취향 추천
                    </p>
                  )}

                </div>

              </div>
            )
          })}

        </div>

      </div>

      <button
        className="back-button"
        onClick={() => setPage('friends')}
      >
        친구 목록으로 돌아가기
      </button>

    </div>
  )
}

export default GiftRecommend