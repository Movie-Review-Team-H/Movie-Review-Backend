# Backend

# 💎 기술 스택별 요구사항

### Kotlin + Springboot

- 빌드 도구는 gradle를 사용해주세요.
- Spring data JPA를 사용해주세요.

# 💡 도메인

- Movie
- Review

# ⭐️ 기능

## `[📽️ 영화]`

### **1. 영화 등록**

- 제목, 장르, 개봉일, 상영 종료일, 상영 중 여부 정보를 포함해야 합니다.
- 등록 일자를 저장해야 합니다.
- 장르는 스릴러, 로맨스, 코믹, 액션 네 가지만 등록 가능합니다.
- 제목을 null로 등록하려고 할 때 예외를 처리합니다. (추가기능)

### **2. 영화 삭제**

- soft delete로 구현하여 영화 삭제시 리뷰 정보가 삭제 되지 않도록 합니다.
- 조회 기능에서 삭제 처리된 영화는 조회하지 않도록 합니다.

### **3. 영화 수정**

- 제목, 장르, 개봉일, 상영 종료일, 상영 중 여부를 수정합니다.
- 수정 일자가 업데이트되어야 합니다.

### **4. 영화 단일 조회**

- 제목, 장르, 개봉일, 상영 종료일, 상영 중 여부 정보를 반환합니다.
- 존재하지 않는 영화를 조회할 경우의 예외를 처리합니다. (추가기능)

### **5. 영화 목록 조회**

- 하나의 API에서 전체 조회와 장르, 현재 상영중 여부 조건을 선택하여 조회할 수 있어야 합니다. (쿼리 파라미터)
- 개봉일 순으로 정렬합니다.

### **6. 영화 목록 평점 순 조회 (추가기능)**

- 페이지네이션이 가능합니다.
- 영화 정보와 영화별 평점 평균을 반환합니다.

## `[📝 리뷰]`

### **7. 리뷰 등록**

- 영화에 대한 리뷰 등록이 가능해야 합니다.
- 평점 (5점 만점), 리뷰 내용을 포함해야 합니다.

### **8. 리뷰 목록 조회**

- 영화별로 리뷰 목록 조회가 가능해야 합니다.
- 등록일의 역순으로 정렬되어 있어야 합니다.
- 평점 평균 n점 이상만 조회하도록 필터링 조건을 추가할 수 있어야 합니다. (추가기능) 예) 평점 평균 3 이상 리뷰 조회
