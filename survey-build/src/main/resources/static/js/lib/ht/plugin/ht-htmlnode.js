!function(K){"use strict";var u="ht",w=K[u],_=function(){return document},g=function(){return _().body},N=function(r,Y,q){r.style.setProperty(Y,q,null)},p=function(A){return _().createElement(A)},F=function(){return p("div")},j=function(){var o=p("canvas");return o},f=function(T,r){N(T,"-webkit-transform",r),N(T,"-ms-transform",r),N(T,"transform",r)},T=function(r,R){N(r,"-webkit-transform-origin",R),N(r,"-ms-transform-origin",R),N(r,"transform-origin",R)},o=function(t,Y){t.appendChild(Y)},S=function(d,k){d.removeChild(k)},A=K.parseInt,y=w.Default,D=y.getInternal(),e=Math.PI,q="white-space",M="visibility",Q="left",c="top",R="width",E="height",H="position",J="display",P="z-index",X="px",B="0 0",v="absolute",W="visible",l="hidden",z="none",I="block",C="nowrap",r="rgba(0, 0, 0, 0.005)";y.setImage("node_dragger","data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAN9JREFUeNrsV9sNhDAMKyzQVdgARmGzrMJNUFZhAh6nfkVcG9PQgHSR8lEksJs6pnGuLCimSRzAa0yyBK9O4gy8GokU+O0kJOAwiQYg0LP1xNYDW3+0CfBYNb7VOuN4LAGpiOaYUhFDas9F2NPHDELNENJqaHgBgSQJ3ufakfQJqckERcOiK+Ae1FGWBNKGh9oX5WPpLpdNYfffijbsxTHh7VKP7388n1g1h7OKUoUuyGpJakQEuhwkZAKcDXVOdWcrOrL/feBVBHI/q8fcjE1nA9PpyHQ+NJ2Qi8A3AQYAOtS27fCoRY0AAAAASUVORK5CYII=");var U=w.graph.GraphView.prototype,G=U._42;U.adjustHtmlNodeIndex=!0,U._42=function(k,w){if(G.call(this,k,w),this.adjustHtmlNodeIndex)for(var M=this.getDataModel()._datas._as,y=M.length,v=1,x=0;y>x;x++){var o=M[x];if(o instanceof n){var O=this.getDataUI(o);N(O.$2f,P,v+""),N(O.$3f,P,v+1+""),v+=2}}};var t=w.HtmlNodeUI=function(g,V){var n=this;t.superClass.constructor.call(n,g,V);var $=n.$2f=F(),x=n.$3f=j();N($,H,v),N($,M,l),N($,q,C),x.draggable=!1,N(x,H,v),N(x,J,z),T(x,B),$.addEventListener("change",function(h){var S=h.target,E=S.bind||S.getAttribute("bind"),i=S.type&&"checkbox"===S.type?S.checked:S.value,f=V.getContext();E&&f&&(f[E]=i,n.$4f=JSON.stringify(f))}),["mousedown","touchstart","keydown","mousewheel","DOMMouseScroll"].forEach(function(B){$.addEventListener(B,this.$9f.bind(this))},n)};y.def(t,D.ui().NodeUI,{_visible:!0,$11f:function(){var M=this,t=M.$3f,o=M._data,H=o.getDraggerImageWidth(),N=o.getDraggerImageHeight(),Q=o.getDraggerImage(),f=D.initContext(t);f.beginPath(),D.setCanvas(t,H,N),D.translateAndScale(f,0,0,1),f.clearRect(0,0,H,N),y.drawImage(f,y.getImage(Q),0,0,H,N),f.restore()},_80o:function(j){t.superClass._80o.call(this,j);var m=this,U=m._data,q=U._padding,x=2*q,_=m.$2f,O=m.$3f,Z=m.gv,V=Z.getZoom(),Y=Z.getTranslateX(),h=Z.getTranslateY(),b=Z.getView(),k=m._83o,T=U._width,D=U._height,g=k.position,n=k.rotation,S=(T-x)/U.$5f*V,K=(D-x)/U.$6f*V,y=m._html,s=U._html,i=U.getHtmlType();if("html"===i){var p=U.getContext()||{},L=m.$4f,B=U.$10f,G=JSON.stringify(p);y&&L&&y===s&&L===G||(m.$4f=G,m._html=s,_.innerHTML=B?B(p):s)}else if(null!=i){var u=U.getHtml();"ht"===i&&(u=u.getView()),y&&y===u&&_.contains(y)||(m._html=u,_.innerHTML="",o(_,u))}if(!_.parentNode){var $=Z.$1f;if(!$){var C=F();N(C,H,v),N(C,P,"0"),$=Z.$1f=C;var w=Z._canvas.nextSibling;w?b.insertBefore(C,w):o(b,C)}o($,_),o($,O),U.onContentInitialized&&U.onContentInitialized(_)}if(U._scalable){var a=U.$5f,d=U.$6f;f(_,"rotate("+180*(n/e)+"deg) scale("+S+","+K+")"),N(_,R,""),N(_,E,""),N(_,Q,(g.x-a/V/2)*V+Y+X),N(_,c,(g.y-d/V/2)*V+h+X)}else{var sn=A(_.style.width),_b=A(_.style.height),_j=A((T-x)*V),Bh=A((D-x)*V),Kh="100%",dm=_.children[0];N(dm,R,Kh),N(dm,E,Kh),(sn!==_j||_b!==Bh)&&(N(_,R,_j+X),N(_,E,Bh+X),"ht"===i&&s.invalidate()),f(_,"rotate("+180*(n/e)+"deg)"),N(_,Q,(g.x-_j/V/2)*V+Y+X),N(_,c,(g.y-Bh/V/2)*V+h+X)}var wd=m.dragRect;Z.isMovable(U)&&Z.isSelected(U)&&wd?(j.save(),j.fillStyle=r,j.fillRect(wd.x,wd.y,wd.width,wd.height),j.restore(),N(O,Q,wd.x*V+Y+X),N(O,c,wd.y*V+h+X),f(O,"scale("+V+","+V+")"),N(O,J,I),m.$11f()):N(O,J,z),N(_,M,this._visible?W:l)},dispose:function(){var w=this.gv.$1f;this.$2f.parentNode===w&&w.removeChild(this.$2f),this.$3f.parentNode===w&&w.removeChild(this.$3f)},_84o:function(w){this._visible=w,N(this.$2f,M,w?W:l),N(this.$3f,J,w?I:z)},_3O:function(){var _=this,U=_.gv,o=_._data;t.superClass._3O.call(_);var w=o.getRect();U.isEditable(o)&&(_.dragRect={x:w.x+w.width+o._padding,y:w.y+10,width:o.getDraggerImageWidth(),height:o.getDraggerImageHeight()},_._68o(_.dragRect))},rectIntersects:function(H){var x=this._79o();return w.Default.intersection(x,H)?!0:void 0},$9f:function(W){var b=this.gv,H=this._data;b.sm().contains(H)&&W.stopPropagation()}});var n=w.HtmlNode=function(){n.superClass.constructor.call(this)};w.Default.def(n,w.Node,{ms_ac:["html","context","scalable","padding","draggerImage","draggerImageWidth","draggerImageHeight"],_padding:w.Default.isTouchable?12:6,_image:null,_scalable:!0,_draggerImage:"node_dragger",_draggerImageWidth:20,_draggerImageHeight:20,setHtml:function(c){var N=this,w=N._html;N._html=c,"html"===N.getHtmlType()&&"Handlebars"in K&&(N.$10f=Handlebars.compile(c)),N.$13f(),N.fp("html",w,c)},setContext:function(N){var x=this,D=x._context;x._context=N,x.fp("context",D,N),x.$13f()},setScalable:function(G){var t=this,K=t._scalable;t._scalable=G,t.fp("scalable",K,G),t.$13f()},getHtmlType:function(){var r=this._html;return r?"string"==typeof r?"html":r.getView?"ht":"dom":null},$13f:function(){var Q=this,B=Q._html,d=Q.$10f;if(B){var z=F(),_=!1,X=Q.getHtmlType();if(N(z,H,v),N(z,q,C),N(z,M,l),"html"===X?(z.innerHTML=d?d(Q.getContext()||{}):B,_=!0):"ht"===X?(o(z,B.getView()),_=!0):"dom"===X&&(o(z,B),_=!0),_){var K=2*Q._padding;o(g(),z),Q.$5f=z.scrollWidth,Q.$6f=z.scrollHeight,Q._width=Q.$5f+K,Q._height=Q.$6f+K,Q._originWidth=Q._width,Q._originHeight=Q._height,S(g(),z)}}},getUIClass:function(){return w.HtmlNodeUI}})}("undefined"!=typeof global?global:"undefined"!=typeof self?self:"undefined"!=typeof window?window:this,Object);