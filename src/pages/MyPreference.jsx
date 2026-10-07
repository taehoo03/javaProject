import { useState } from 'react'

function MyPreference() {
  const savedPreference = JSON.parse(
    localStorage.getItem('preference')
  )

  const [interest, setInterest] = useState(
    savedPreference ? savedPreference.interest : ''
  )

  const [favorite, setFavorite] = useState(
    savedPreference ? savedPreference.favorite : ''
  )

  const [gift, setGift] = useState(
    savedPreference ? savedPreference.gift : ''
  )

  const [saved, setSaved] = useState(
    savedPreference ? true : false
  )

  const handleSave = () => {
    if (!interest || !favorite || !gift) {
      alert('취향 정보를 모두 입력해주세요.')
      return
    }

    const preference = {
      interest,
      favorite,
      gift
    }

    localStorage.setItem(
      'preference',
      JSON.stringify(preference)
    )

    setSaved(true)

    alert('취향이 저장되었습니다.')
  }

  return (
    <div className="friends-page">

      <div className="friends-title">

        <div>
          <h2>내 취향</h2>

          <p>
            나의 취향을 등록하면 선물 추천에 활용할 수 있어요.
          </p>
        </div>

      </div>

      <div className="friend-detail">

        <h2>취향 정보</h2>

        <p>
          좋아하는 것과 선호하는 선물을 입력해주세요.
        </p>

        <div className="signup-form">

          <label>관심 분야</label>

          <input
            type="text"
            value={interest}
            onChange={(e) => setInterest(e.target.value)}
            placeholder="예: 여행, 음악, 게임"
          />

          <label>좋아하는 것</label>

          <input
            type="text"
            value={favorite}
            onChange={(e) => setFavorite(e.target.value)}
            placeholder="예: 향수, 책, 카페"
          />

          <label>선호하는 선물</label>

          <input
            type="text"
            value={gift}
            onChange={(e) => setGift(e.target.value)}
            placeholder="예: 실용적인 물건"
          />

          <button onClick={handleSave}>
            취향 저장하기
          </button>

        </div>

      </div>

      {saved && (
        <div className="friend-detail">

          <h2>등록된 내 취향</h2>

          <div className="preference">
            <strong>관심 분야</strong>
            <span>{interest}</span>
          </div>

          <div className="preference">
            <strong>좋아하는 것</strong>
            <span>{favorite}</span>
          </div>

          <div className="preference">
            <strong>선호하는 선물</strong>
            <span>{gift}</span>
          </div>

        </div>
      )}

    </div>
  )
}

export default MyPreference