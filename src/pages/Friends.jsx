import { useState } from 'react'

function Friends({ setPage }) {
  const [friends, setFriends] = useState([
    {
      id: 1,
      name: '김하늘',
      relation: '대학 친구',
      birthday: '10월 10일',
      interest: '여행, 카페, 음악',
      favorite: '향수, 책, 소품',
      gift: '실용적인 물건'
    },
    {
      id: 2,
      name: '박지민',
      relation: '친구',
      birthday: '10월 25일',
      interest: '게임, 운동, 영화',
      favorite: '게임용품, 운동용품',
      gift: '실용적인 물건'
    }
  ])

  const [selectedFriend, setSelectedFriend] = useState(null)
  const [showForm, setShowForm] = useState(false)

  const [name, setName] = useState('')
  const [relation, setRelation] = useState('')
  const [birthday, setBirthday] = useState('')

  const handleAddFriend = () => {
    if (!name || !relation || !birthday) {
      alert('친구 정보를 모두 입력해주세요.')
      return
    }

    const newFriend = {
      id: Date.now(),
      name,
      relation,
      birthday,
      interest: '아직 등록된 취향이 없습니다.',
      favorite: '아직 등록된 취향이 없습니다.',
      gift: '아직 등록된 취향이 없습니다.'
    }

    setFriends([...friends, newFriend])

    setName('')
    setRelation('')
    setBirthday('')
    setShowForm(false)

    alert('친구가 추가되었습니다.')
  }

  const handleSelectFriend = (friend) => {
    const savedPreference = JSON.parse(
      localStorage.getItem('preference')
    )

    if (
      savedPreference &&
      friend.interest.includes('아직')
    ) {
      setSelectedFriend({
        ...friend,
        interest: savedPreference.interest,
        favorite: savedPreference.favorite,
        gift: savedPreference.gift
      })
    } else {
      setSelectedFriend(friend)
    }
  }

  return (
    <div className="friends-page">

      <div className="friends-title">

        <div>
          <h2>내 친구</h2>
          <p>친구의 취향을 확인하고 선물을 골라보세요.</p>
        </div>

        <button onClick={() => setShowForm(!showForm)}>
          {showForm ? '닫기' : '친구 추가'}
        </button>

      </div>

      {showForm && (
        <div className="friend-detail">

          <h2>친구 추가</h2>
          <p>친구의 정보를 입력해주세요.</p>

          <div className="signup-form">

            <label>이름</label>

            <input
              type="text"
              value={name}
              onChange={(e) => setName(e.target.value)}
              placeholder="친구 이름을 입력해주세요."
            />

            <label>관계</label>

            <input
              type="text"
              value={relation}
              onChange={(e) => setRelation(e.target.value)}
              placeholder="예: 대학 친구, 회사 동료"
            />

            <label>생일</label>

            <input
              type="date"
              value={birthday}
              onChange={(e) => setBirthday(e.target.value)}
            />

            <button onClick={handleAddFriend}>
              친구 추가하기
            </button>

          </div>

        </div>
      )}

      <div className="friend-list">

        {friends.map((friend) => (
          <div
            className="friend"
            key={friend.id}
            onClick={() => handleSelectFriend(friend)}
          >

            <div className="friend-info">

              <strong>{friend.name}</strong>

              <span>{friend.relation}</span>

              <span>{friend.birthday}</span>

            </div>

            <span className="ready">
              {friend.interest.includes('아직')
                ? '취향 미등록'
                : '취향 준비됨'}
            </span>

          </div>
        ))}

      </div>

      {selectedFriend && (
        <div className="friend-detail">

          <h2>{selectedFriend.name}의 취향</h2>

          <p>{selectedFriend.relation}</p>

          <div className="preference">
            <strong>관심 분야</strong>
            <span>{selectedFriend.interest}</span>
          </div>

          <div className="preference">
            <strong>좋아하는 것</strong>
            <span>{selectedFriend.favorite}</span>
          </div>

          <div className="preference">
            <strong>선호하는 선물</strong>
            <span>{selectedFriend.gift}</span>
          </div>

          <button onClick={() => setPage('recommend')}>
            이 친구에게 선물하기
          </button>

        </div>
      )}

    </div>
  )
}

export default Friends