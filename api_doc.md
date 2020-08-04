## playlist API 문서
Restful URI를 적용하였습니다. 사용 목적에 따라 리퀘스트를 전송할 때 method의 종류를 POST, PUT, GET, DELETE 로 변경하시면 됩니다.
_____

#### Playlist 생성 API
POST를 사용해 전송합니다. 
* `userId` : 사용자 아이디
* `title`: 플레이리스트의 제목을 입력합니다. (255자 이내)

##### 주소
````
SERVER_URL/playlist/
````

##### CURL 테스트 예제
````
curl -X POST -d "userId=235&title=POPS" http://localhost:8080/playlist/
````
---
#### Playlist 삭제 API
DELETE를 사용해 삭제합니다. 
* `userId` : 사용자 아이디 (리퀘스트 파라미터로 전송)
* `playlistId` : 데이터베이스에 등록된 플레이리스트의 고유 id를 입력합니다. (URL에 포함)

##### 주소
````
SERVER_URL/playlist/{playlistId}
````

##### CURL 테스트 예제
````
curl -X DELETE -d "userId=235" http://localhost:8080/playlist/1
````
---
#### Playlist 조회 API
특정 사용자 아이디가 생성한 플레이리스트를 조회합니다. GET을 사용하며 웹 브라우저에서도 별도 설정 없이 접근할 수 있습니다.
* `userId` : 사용자 아이디 (URL에 포함)

##### 주소
````
SERVER_URL/playlist/{playlistId}
````
_____

#### Playlist 곡 추가 API
PUT을 이용해 특정 플레이리스트에 곡을 추가할 수 있습니다. `songId`, `albumId` 둘 중 하나의 파라미터는 필수입니다. 

`songId`가 주어지면 특정 곡을 추가합니다. `albumId`가 주어지면 특정 앨범에 있는 모든 곡들을 플레이리스트에 추가합니다. 
* `playlistId` : 플레이리스트 아이디 (URL에 추가)
* `userId` : 사용자 아이디
* `songId` : 데이터베이스에 등록된 특정 곡의 고유 아이디 번호
* `albumId` : 데이터베이스에 등록된 특정 앨범의 고유 아이디 번호

##### 주소
````
SERVER_URL/playlist/{playlistId}
````

##### CURL 테스트 예제
````
curl -X PUT -d "userId=235&songId=532" http://localhost:8080/playlist/50
````
