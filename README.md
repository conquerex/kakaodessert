
<img src="https://github.com/conquerex/kakaodessert/blob/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.png?raw=true" width="20%">

# KakaoDessert

[![Platform](https://img.shields.io/badge/platform-Android-green.svg) ]()
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

> Flickr Open API에서 얻은 디저트 이미지를 Grid 화면으로 보여준다.

## :baby: Code Convention

- 변수명은 camelCase로 작성한다.
- API Key와 같이 공개되어서는 안되는 것은 `.gitignore`로 관리한다.
- 시작 중괄호는 "{" 따로 한줄을 차지하지 않는다.
- 축약어는 단어처럼 취급할 것.
- 로깅(Log)은 간결하게.

## :facepunch: Open API : Flickr 

디저트 이미지를 Grid 형태의 리스트로 보여주고 각각의 아이템을 클릭하면 상세화면에 진입할 수 있다.

- 아래 메소드를 사용하려면 [REST 요청 형식](https://www.flickr.com/services/api/request.rest.html)을 참고한다.
- [flickr.photos.search](https://www.flickr.com/services/api/flickr.photos.search.html) : 이미지 검색 메소드
- [flickr.photos.getInfo](https://www.flickr.com/services/api/flickr.photos.getInfo.html) : 이미지 상세정보 메소드
- [사진 소스 URL](https://www.flickr.com/services/api/misc.urls.html)은 위 메소드로부터 받을 수 있는 사진 ID, Farm, Server 정보 등을 통해 얻을 수 있다.

```bash
api_key를 필수로 발급받아야 한다.
Json으로 response를 받고 싶으면 format과 nojsoncallback를 인자로 받아야 한다.
Flickr API에서는 모든 데이터가 UTF-8 인코딩되어야 한다.
```


## :pouting_cat: Github branching 
- 협업이 필요하거나 이슈가 많지 않기에 `master` 브랜치 하나로 진행한다.


## :open_file_folder: Open Source

- `square/retrofit`
TypeSafe한 HttpClient 라이브러리. OkHttp에 의존

- `bumptech/glide`
이미지 로딩 라이브러리

- `airbnb/lottie-android`
네이티브 앱에서 high-quality 애니메이션(Json 파일)을 추가.


## :whale: Todo

- `SwipeRefreshLayout`으로 최신 데이터를 받을 수 있도록 한다.
- 최상단으로 이동할 수 있는 버튼틀 추가한다.


## :baby_chick: Demo
<p float="left">
    <img src="https://github.com/conquerex/kakaodessert/blob/master/app/src/main/res/raw/demo_kakaodessert_1.png?raw=true" />
    <img src="https://github.com/conquerex/kakaodessert/blob/master/app/src/main/res/raw/demo_kakaodessert_2.png?raw=true" />
</p>
