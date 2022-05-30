
import React, { useEffect } from 'react';

const { kakao } = window;

const MapContainer = ({ searchPlace}) => {

  useEffect(() => {
    const container = document.getElementById("myMap");
    const options = {
      center: new kakao.maps.LatLng(33.450701, 126.570667),
      level: 4,
    };
    const map = new kakao.maps.Map(container, options);

    const geocoder = new kakao.maps.services.Geocoder();

    geocoder.addressSearch(searchPlace.fa_RDNMA, function(result, status) {

        // 정상적으로 검색이 완료됐으면
         if (status === kakao.maps.services.Status.OK) {

            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: coords
            });

            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new kakao.maps.InfoWindow({
                content: '<div style="width:150px;text-align:center;padding:6px 0; ">'+searchPlace.aca_NM+'</div>'
            });
            infowindow.open(map, marker);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        }
    });


    function displayMarker(place) {
      let marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x),
      });
    }
  }, [searchPlace]);

    return (
        <div id='myMap' style={{
            width: '100%',
            height: '500px'
        }}></div>
    );
}

export default MapContainer;