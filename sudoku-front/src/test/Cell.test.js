import useCurser from '../hook/useCurser';
// OnClick Test
// updateCurser()를 테스트 할 경우
// 사용되야하는 변수 board, 임의 x값, 임의 y값..?

// 셀 클릭 되는지 안되는지
//
// 원하는 형태
//  it('cell click', () => {
//     임의 값 X,Y가 있음
//      FIREEVENT.CLICK을 사용해서 클릭이벤트 발생
//      UPDATECURSER를 하면 임의의 값이 현재 CELL의 X,Y 값으로 바뀜을 확인
// })
//
// 원하는 형태 
//  it('cell click', () => {
//      보드 필요(보드를 임의로 만들면되나?)
//      임의 값 X,Y가 있음
//      FIREEVENT.CLICK을 사용해서 클릭이벤트 발생
//      UPDATECURSER를 하면 임의의 값이 현재 CELL의 X,Y 값으로 바뀜을 확인
//      UPDATENUMBOARD함수를 통해 해당 X, Y값의 배열이 변경
//      
// })
const {curX,curY,updateCurser} = useCurser();

describe('Cursor Test', () => {
    it('update cursor테스트', () => {
        expect(updateCurser(5, 7)).toBe({
            curX: 5,
            curY: 7,
        })
    })
})

