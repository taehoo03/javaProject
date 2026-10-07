import { useEffect, useState } from 'react'
import axios from 'axios'

function Friends({ setPage }) {
  const [friends, setFriends] = useState([])
  const [selectedFriend, setSelectedFriend] = useState(null)
  const [showForm, setShowForm] = useState(false)

  const [name, setName] = useState('')
  const [relation, setRelation] = useState('')
  const [birthday, setBirthday] = useState('')

  const loginUser = JSON.parse(
    localStorage.getItem('loginUser')
  )

  const memberId = loginUser?.memberId

  useEffect(() => {
    if (memberId) {
      loadFriends()
    }
  }, [memberId])

  const loadFriends = async () => {
    try {
      const friendResponse = await axios.get(
        'http://localhost:8080/api/friends',
        {
          params: {
            memberId
          }
        }
      )

      const memberResponse = await axios.get(
        'http://localhost:8080/api/members'
      )

      const members = memberResponse.data

      const friendData = await Promise.all(
        friendResponse.data.map(
          async (friend) => {
            const member = members.find(
              (member) =>
                member.memberId ===
                friend.friendMemberId
            )

            let preference = null

            try {
              const preferenceResponse =
                await axios.get(
                  'http://localhost:8080/api/preferences',
                  {
                    params: {
                      memberId:
                        friend.friendMemberId
                    }
                  }
                )

              preference = preferenceResponse.data
            } catch (error) {
              preference = null
            }

            return {
              id: friend.friendId,
              memberId: friend.friendMemberId,
              name: member
                ? member.name
                : '회원 정보 없음',
              relation: '친구',
              birthday: member
                ? member.birth
                : '',
              interest: preference
                ? preference.interest
                : '아직 등록된 취향이 없습니다.',
              favorite: preference
                ? preference.favorite
                : '아직 등록된 취향이 없습니다.',
              gift: preference
                ? preference.gift
                : '아직 등록된 취향이 없습니다.'
            }
          }
        )
      )

      setFriends(friendData)
    } catch (error) {
      alert('친구 목록을 불러오지 못했습니다.')
    }
  }

  const handleAddFriend = async () => {
    if (!name || !relation || !birthday) {
      alert('친구 정보를 모두 입력해주세요.')
      return
    }

    if (!memberId) {
      alert('로그인 후 친구를 추가할 수 있습니다.')
      setPage('login')
      return
    }

    try {
      const memberResponse = await axios.get(
        'http://localhost:8080/api/members'
      )

      const member = memberResponse.data.find(
        (member) =>
          member.name === name &&
          member.birth === birthday
      )

      if (!member) {
        alert('가입된 회원을 찾을 수 없습니다.')
        return
      }

      if (member.memberId === memberId) {
        alert('본인은 친구로 추가할 수 없습니다.')
        return
      }

      const alreadyFriend = friends.some(
        (friend) =>
          friend.memberId === member.memberId
      )

      if (alreadyFriend) {
        alert('이미 추가된 친구입니다.')
        return
      }

      await axios.post(
        'http://localhost:8080/api/friends',
        {
          memberId,
          friendMemberId: member.memberId
        }
      )

      await loadFriends()

      setName('')
      setRelation('')
      setBirthday('')
      setShowForm(false)

      alert('친구가 추가되었습니다.')
    } catch (error) {
      alert('친구 추가에 실패했습니다.')
    }
  }

  const handleDeleteFriend = async (friendId) => {
    const result = window.confirm(
      '이 친구를 삭제하시겠습니까?'
    )

    if (!result) {
      return
    }

    try {
      await axios.delete(
        'http://localhost:8080/api/friends',
        {
          params: {
            friendId
          }
        }
      )

      if (
        selectedFriend &&
        selectedFriend.id === friendId
      ) {
        setSelectedFriend(null)
      }

      await loadFriends()

      alert('친구가 삭제되었습니다.')
    } catch (error) {
      alert('친구 삭제에 실패했습니다.')
    }
  }

  const handleSelectFriend = (friend) => {
    setSelectedFriend(friend)
  }

  const handleGift = () => {
    localStorage.setItem(
      'selectedFriend',
      JSON.stringify(selectedFriend)
    )

    setPage('recommend')
  }

  return (
    <div className="friends-page">

      <div className="friends-title">
        <div>
          <h2>친구</h2>
          <p>
            친구의 취향을 확인하고 선물을 추천받아보세요.
          </p>
        </div>

        <button
          className="add-friend-button"
          onClick={() => setShowForm(!showForm)}
        >
          친구 추가
        </button>
      </div>

      {showForm && (
        <div className="friend-add-form">

          <input
            type="text"
            value={name}
            onChange={(e) =>
              setName(e.target.value)
            }
            placeholder="친구 이름"
          />

          <input
            type="text"
            value={relation}
            onChange={(e) =>
              setRelation(e.target.value)
            }
            placeholder="관계"
          />

          <input
            type="text"
            value={birthday}
            onChange={(e) =>
              setBirthday(e.target.value)
            }
            placeholder="생년월일"
          />

          <button onClick={handleAddFriend}>
            추가하기
          </button>

        </div>
      )}

      <div className="friends-content">

        <div className="friends-list">

          {friends.length === 0 ? (
            <p>등록된 친구가 없습니다.</p>
          ) : (
            friends.map((friend) => (
              <div
                className="friend-card"
                key={friend.id}
                onClick={() =>
                  handleSelectFriend(friend)
                }
              >
                <div>
                  <strong>{friend.name}</strong>
                  <p>{friend.relation}</p>
                </div>

                <button
                  onClick={(e) => {
                    e.stopPropagation()
                    handleDeleteFriend(friend.id)
                  }}
                >
                  삭제
                </button>
              </div>
            ))
          )}

        </div>

        {selectedFriend && (
          <div className="friend-detail">

            <div className="friend-detail-header">
              <div>
                <h3>{selectedFriend.name}</h3>
                <p>
                  {selectedFriend.relation}
                </p>
              </div>
            </div>

            <div className="friend-info">

              <div>
                <span>생년월일</span>
                <strong>
                  {selectedFriend.birthday}
                </strong>
              </div>

              <div>
                <span>관심사</span>
                <strong>
                  {selectedFriend.interest}
                </strong>
              </div>

              <div>
                <span>좋아하는 것</span>
                <strong>
                  {selectedFriend.favorite}
                </strong>
              </div>

              <div>
                <span>받고 싶은 선물</span>
                <strong>
                  {selectedFriend.gift}
                </strong>
              </div>

            </div>

            <button
              className="gift-button"
              onClick={handleGift}
            >
              이 친구에게 선물하기
            </button>

          </div>
        )}

      </div>

    </div>
  )
}

export default Friends