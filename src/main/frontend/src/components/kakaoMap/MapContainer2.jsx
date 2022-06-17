import React, { useEffect } from 'react';

const { kakao } = window;

const MapContainer2 = ({ placeList }) => {
    console.log(placeList)
  useEffect(() => {
/*
    const container = document.getElementById("myMap");
    const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 13,
    };
    const map = new kakao.maps.Map(container, options);
*/
    var map = new kakao.maps.Map(document.getElementById('myMap'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
        level : 13 // 지도의 확대 레벨
    });
    const geocoder = new kakao.maps.services.Geocoder();

    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 10, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });

    var markers = [] ;

    for(let i = 0; i <placeList.length; i++) {
        geocoder.addressSearch(placeList[i].fa_RDNMA, function(result, status) {

            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new kakao.maps.Marker({  map: map, position: coords  });
            console.log(marker);
            markers.push(marker);
            console.log(markers);
/*
           var markers = coords.map(function(i, position) {
               return new kakao.maps.Marker({
                   position : new kakao.maps.LatLng(position.lat, position.lng)
               });
           });
           // 인포윈도우로 장소에 대한 설명을 표시합니다
           var infowindow = new kakao.maps.InfoWindow({
               content: '<div style="width:150px;text-align:center;padding:6px 0; ">'+searchPlace[i].aca_NM+'</div>'
           });
    */
        clusterer.addMarkers(markers);
        });
    }
    console.log(clusterer);




       kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

             // 현재 지도 레벨에서 1레벨 확대한 레벨
             var level = map.getLevel()-1;

             // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
             map.setLevel(level, {anchor: cluster.getCenter()});
         });

  }, [placeList]);

    return (
        <div id='myMap' style={{
            width: '100%',
            height: '1000px'
        }}></div>
    );
}

export default MapContainer2;