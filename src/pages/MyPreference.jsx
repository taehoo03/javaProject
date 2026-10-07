import { useEffect, useState } from 'react'
import axios from 'axios'

function MyPreference({ setPage }) {
  const loginUser = JSON.parse(
    localStorage.getItem('loginUser')
  )

  const memberId = loginUser?.memberId

  const interestOptions = [
    '음악',
    '여행',
    '운동',
    '게임',
    '독서',
    '영화'
  ]

  const favoriteOptions = [
    '향수',
    '카페',
    '디저트',
    '꽃',
    '책',
    '문구',
    '패션',
    '음악'
  ]

  const giftOptions = [
    '향수',
    '소품',
    '책',
    '카페',
    '여행',
    '음악',
    '디저트',
    '꽃',
    '문구',
    '생활',
    '뷰티',
    '취미'
  ]

  const [interest, setInterest] = useState([])
  const [favorite, setFavorite] = useState([])
  const [gift, setGift] = useState([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    if (memberId) {
      loadPreference()
    } else {
      setLoading(false)
    }
  }, [memberId])

  const loadPreference = async () => {
    try {
      const response = await axios.get(
        'http://localhost:8080/api/preferences',
        {
          params: {
            memberId
          }
        }
      )

      if (response.data) {
        setInterest(
          response.data.interest
            ? response.data.interest.split(',')
            : []
        )

        setFavorite(
          response.data.favorite
            ? response.data.favorite.split(',')
            : []
        )

        setGift(
          response.data.gift
            ? response.data.gift.split(',')
            : []
        )
      }
    } catch (error) {
      alert('취향 정보를 불러오지 못했습니다.')
    } finally {
      setLoading(false)
    }
  }

  const toggleOption = (
    value,
    selected,
    setSelected
  ) => {
    if (selected.includes(value)) {
      setSelected(
        selected.filter(
          (item) => item !== value
        )
      )
    } else {
      setSelected([
        ...selected,
        value
      ])
    }
  }

  const handleSave = async () => {
    if (!memberId) {
      alert('로그인 후 취향을 등록해주세요.')
      return
    }

    if (
      interest.length === 0 ||
      favorite.length === 0 ||
      gift.length === 0
    ) {
      alert('각 항목에서 하나 이상 선택해주세요.')
      return
    }

    const preference = {
      memberId,
      interest: interest.join(','),
      favorite: favorite.join(','),
      gift: gift.join(',')
    }

    try {
      const response = await axios.get(
        'http://localhost:8080/api/preferences',
        {
          params: {
            memberId
          }
        }
      )

      if (response.data) {
        await axios.put(
          'http://localhost:8080/api/preferences',
          preference
        )

        alert('취향이 수정되었습니다.')
      } else {
        await axios.post(
          'http://localhost:8080/api/preferences',
          preference
        )

        alert('취향이 저장되었습니다.')
      }

      localStorage.setItem(
        'preference',
        JSON.stringify(preference)
      )

      setPage('home')
    } catch (error) {
      alert('취향 저장에 실패했습니다.')
    }
  }

  if (loading) {
    return (
      <div className="friends-page">
        <h2>취향 정보를 불러오는 중입니다.</h2>
      </div>
    )
  }

  if (!memberId) {
    return (
      <div className="friends-page">
        <h2>내 취향</h2>
        <p>로그인 후 취향을 등록할 수 있습니다.</p>
      </div>
    )
  }

  return (
    <div className="friends-page">
      <div className="friends-title">
        <div>
          <h2>내 취향</h2>
          <p>
            선물 추천을 위해 나의 취향을 등록해주세요.
          </p>
        </div>
      </div>

      <div className="friend-detail">
        <div className="preference-form">
          <div>
            <label>관심사</label>
            <div className="preference-options">
              {interestOptions.map((option) => (
                <button
                  type="button"
                  key={option}
                  className={
                    interest.includes(option)
                      ? 'preference-option selected'
                      : 'preference-option'
                  }
                  onClick={() =>
                    toggleOption(
                      option,
                      interest,
                      setInterest
                    )
                  }
                >
                  {option}
                </button>
              ))}
            </div>
          </div>

          <div>
            <label>좋아하는 것</label>
            <div className="preference-options">
              {favoriteOptions.map((option) => (
                <button
                  type="button"
                  key={option}
                  className={
                    favorite.includes(option)
                      ? 'preference-option selected'
                      : 'preference-option'
                  }
                  onClick={() =>
                    toggleOption(
                      option,
                      favorite,
                      setFavorite
                    )
                  }
                >
                  {option}
                </button>
              ))}
            </div>
          </div>

          <div>
            <label>받고 싶은 선물</label>
            <div className="preference-options">
              {giftOptions.map((option) => (
                <button
                  type="button"
                  key={option}
                  className={
                    gift.includes(option)
                      ? 'preference-option selected'
                      : 'preference-option'
                  }
                  onClick={() =>
                    toggleOption(
                      option,
                      gift,
                      setGift
                    )
                  }
                >
                  {option}
                </button>
              ))}
            </div>
          </div>

          <button onClick={handleSave}>
            취향 저장
          </button>
        </div>
      </div>
    </div>
  )
}

export default MyPreference