import { useEffect, useState } from 'react'
import axios from 'axios'

function MemberManage() {
  const [members, setMembers] = useState([])

  useEffect(() => {
    loadMembers()
  }, [])

  const loadMembers = async () => {
    try {
      const response = await axios.get(
        'http://localhost:8080/api/members'
      )

      setMembers(response.data)
    } catch (error) {
      alert('회원 데이터를 불러오지 못했습니다.')
    }
  }

  const handleDelete = async (userId) => {
    const result = window.confirm(
      '이 회원을 삭제하시겠습니까?'
    )

    if (!result) {
      return
    }

    try {
      await axios.delete(
        'http://localhost:8080/api/members',
        {
          params: {
            userId
          }
        }
      )

      alert('회원이 삭제되었습니다.')

      await loadMembers()
    } catch (error) {
      alert('회원 삭제에 실패했습니다.')
    }
  }

  return (
    <div className="member-manage-page">

      <div className="manage-title">
        <div>
          <h2>회원관리</h2>
          <p>가입한 회원의 정보를 관리할 수 있습니다.</p>
        </div>
      </div>

      <div className="member-summary">
        <span>전체 회원</span>
        <strong>{members.length}명</strong>
      </div>

      <div className="member-table">

        <div className="member-table-header">
          <span>이름</span>
          <span>아이디</span>
          <span>전화번호</span>
          <span>생년월일</span>
          <span>주소</span>
          <span>관리</span>
        </div>

        {members.map((member) => (
          <div
            className="member-table-row"
            key={member.memberId}
          >
            <span>{member.name}</span>

            <span>{member.userId}</span>

            <span>{member.phone}</span>

            <span>{member.birth}</span>

            <span>
              {member.address}
              {member.detailAddress &&
                ` ${member.detailAddress}`}
            </span>

            <button
              onClick={() => handleDelete(member.userId)}
            >
              삭제
            </button>
          </div>
        ))}

      </div>

    </div>
  )
}

export default MemberManage