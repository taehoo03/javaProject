import { useState } from 'react'

function MemberManage() {
  const savedUser = JSON.parse(localStorage.getItem('user'))

  const [members, setMembers] = useState(
    savedUser
      ? [savedUser]
      : [
          {
            name: '김하늘',
            userId: 'haneul123',
            password: '1234',
            phone: '010-1234-5678',
            birth: '2002-10-10',
            address: '대전광역시',
            detailAddress: '중구'
          },
          {
            name: '박지민',
            userId: 'jimin123',
            password: '1234',
            phone: '010-5678-1234',
            birth: '2001-10-25',
            address: '대전광역시',
            detailAddress: '서구'
          }
        ]
  )

  const handleDelete = (userId) => {
    const result = window.confirm(
      '이 회원을 삭제하시겠습니까?'
    )

    if (!result) {
      return
    }

    setMembers(
      members.filter(
        (member) => member.userId !== userId
      )
    )

    if (savedUser && savedUser.userId === userId) {
      localStorage.removeItem('user')
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
            key={member.userId}
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