// Mysql을 연결하는 JS 싱글톤 예제
const mysql = require('mysql');

// pool은 싱글톤이다.
cosnt pool = mysql.createPool({
    // 대충 연결 정보들 ...
});

// pool 객체를 이용해 연결, 쿼리들을 실행한다.
pool.connet();

pool.query(query,function(error, results, fields){
    // 처리 내용들...
});