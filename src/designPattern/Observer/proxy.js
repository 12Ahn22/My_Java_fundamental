const p = new Proxy({a:'AYO', b:'IS THE BEST!'}, {
  get(target, name){ // get 접근을 가로챈다.
    return name === 'name' ? `${target.a} ${target.b}` : target[name];
  }
});
// 그래서 name에 접근하는 걸 가로채서 get에 설정한 메서드를 실행한거
console.log(p.name);


function createReactiveObject(target, callback){
  const proxy = new Proxy(
    target,{
      set(obj, prop, value){
        if(value !== obj[prop]){
          const prev = obj[prop]; // 이전 값 저장
          obj[prop] = value; // set값으로 변경
          callback(`${prop}가 ${prev} >> ${value}로 변경되었습니다.`);
        }
      }
    }
  );
  return proxy;
}

const a = {"과일":"바나나"};
const b = createReactiveObject(a, console.log);
b.과일 = "바나나";
b.과일 = "사과";
b.과일 = "오렌지";