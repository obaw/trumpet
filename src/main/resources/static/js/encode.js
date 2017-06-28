/**
 * Created by xiaowei on 17-5-3.
 */
function encode(id) {
  var magic = _bytearray('3go8&$8*3*3h0k(2)2');
  var song_id = _bytearray(id.toString());
  var len = magic.length;
  for (var i = 0; i < song_id.length; i++) {
    song_id[i] = song_id[i] ^ magic[i % len]
  }
  song_id = _bytestring(song_id);
  return Crypto.MD564(song_id).replace(/\//g, "_").replace(/\+/g, "-");
}

function _bytearray(str) {
  var res = [];
  for (var i = 0; i < str.length; i++) {
    res.push(str.substr(i, 1).charCodeAt());
  }
  return res;
}

function _bytestring(array) {
  var res = "";
  for (var x in array) {
    res += String.fromCharCode(array[x]);
  }
  return res;
}