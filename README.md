# trumpet
根据网易云音乐api改版的音乐网站

## 网易云API
### 搜索
`GET http://music.163.com/api/search/get/`
```
参数:
s: 搜索的内容
offset: 偏移量
limit: 获取的数量
type: 搜索类型
      1=歌曲,10=专辑,100=歌手,1000=歌单,1002=用户,1004=mv,1006=歌词,1009=主播电台
```

### 歌曲详情
`GET http://music.163.com/api/song/detail`
```text
参数: 
ids: [歌曲ID],多首歌用逗号隔开
```

### 歌词详情
* `GET http://music.163.com/api/song/lyric`
```text
参数: 
id: 歌曲ID
lv: -1,搜索lrc歌词,一般需要这个就好了
kv: -1,搜索klyric歌词
tv: -1,搜索tlyric歌词
```
* `GET http://music.163.com/api/song/media`
```text
参数:
id: 歌曲ID
```

### 歌单详情
`GET http://music.163.com/api/playlist/detail`
```text
参数:
id: 歌单ID
```

### MV
`GET http://music.163.com/api/mv/detail`
```text
id: MVID
type: 格式,MP4
```

### 歌曲下载
`GET http://music.163.com/api/song/enhance/download/url`
```text
参数:
br: 码率
id: 歌曲ID
```
