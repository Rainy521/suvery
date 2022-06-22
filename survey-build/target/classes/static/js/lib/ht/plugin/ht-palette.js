!function(L,x,u){"use strict";var v="px",p="0",y="innerHTML",A="className",X=ht.Default,i=ht.Color,H=ht.Node,S="position",h="top",W="left",V=X.animate,F=X.getInternal(),q="width",p="0",P="none",$="max-height",M="font",C="background",m="border-box",Q="user-select",k="box-sizing",E="overflow",g=X.isTouchable,F=X.getInternal(),f=i.titleIconBackground,K=X.scrollBarInteractiveSize,o=/msie 9/.test(L.navigator?L.navigator.userAgent.toLowerCase():""),O=null,b=function(){return document},Y=function(S){return b().createElement(S)},T=function(){return Y("div")},d=function(){var U=T(),I=U.style;return I.msTouchAction=P,I.cursor="default",g&&I.setProperty("-webkit-tap-highlight-color","rgba(0, 0, 0, 0)",O),I.position="absolute",I.left=p,I.top=p,U},z=function(){return Y("canvas")},Z=function(){return document.body},G=function(G,E,j){G.style.setProperty(E,j,O)},r=function(A,M){A.style.removeProperty(M)},c=function(f,n,N){X.def(ht.widget[f],n,N)},a=function(u,d){u.appendChild(d)},s=function(d,Z){d.removeChild(Z)},n=function(q,A,D,i){q.addEventListener(A,D,!!i)};F.addMethod(X,{paletteExpandIcon:{width:16,height:16,comps:[{type:"triangle",rect:[4,4,10,8],background:f,rotation:3.14}]},paletteCollapseIcon:{width:16,height:16,comps:[{type:"triangle",rect:[4,4,10,8],background:f}]},paletteTitleLabelColor:X.labelSelectColor,paletteTitleLabelFont:X.labelFont,paletteContentLabelFont:X.labelFont,paletteContentLabelColor:"#777",paletteContentBackground:"#fff",paletteTitleHeight:X.widgetTitleHeight,paletteTitleBackground:i.titleBackground,paletteTitleHoverBackground:i.titleBackground,paletteSeparatorWidth:1,paletteSeparatorColor:u,paletteItemHoverBorderColor:i.highlight,paletteItemSelectBackground:i.highlight},!0);var R=".palette-item:hover{border: 1px solid "+X.paletteItemHoverBorderColor+" !important}"+" .palette-header:hover{background: "+X.paletteTitleHoverBackground+" !important}",I=document.createElement("style");g||(I.styleSheet?I.styleSheet.cssText=R:I.appendChild(b().createTextNode(R))),b().getElementsByTagName("head")[0].appendChild(I);var N=function(D){var P=this;P.$22h=D,P.addListeners()};X.def(N,x,{ms_listener:1,getView:function(){return this.$22h.getView()},$26h:function(){var C=this;C.$36h&&Z().removeChild(C.$36h),C.$23h=C.$24h=C.$25h=C.$35h=C.$36h=O},handle_touchstart:function(N){for(var p,Y=this,H=Y.$22h,M=N.target,Z=H.sm(),f=H.dm(),o="palette-header",L="palette-header-tool",h="palette-item",O=!1,S=!1,z=!1;M&&(M[A]||"").indexOf(o)<0&&(M[A]||"").indexOf(h)<0;)M=M.parentNode;if(M&&M[A].indexOf(L)>=0?O=!0:M&&M[A].indexOf(o)>=0?z=!0:M&&M[A].indexOf(h)>=0&&(S=!0),X.isLeftButton(N))if(Y.$27h(N))Y.$24h=X.getClientPoint(N),Y.$25h=H.ty();else if(O){X.preventDefault(N),p=M.parentNode.$11h;var r=f.getDataById(p),I=r.s("tools")[M.toolIndex];I.action&&I.action.call(H)}else if(z){X.preventDefault(N),p=M.$11h;var r=f.getDataById(p);r.isExpanded()?r.setExpanded(!1):r.setExpanded(!0)}else if(S){p=M.$11h;var n=f.getDataById(p);Z.ss(n),H.handleDragAndDrop&&(X.preventDefault(N),n.s("draggable")&&(H.handleDragAndDrop(N,"prepare"),Y.$35h=0)),n.s("draggable")||(X.preventDefault(N),Y.$24h=X.getClientPoint(N),Y.$25h=H.ty())}else X.preventDefault(N),Y.$24h=X.getClientPoint(N),Y.$25h=H.ty();else Y.$26h(N)},handle_mousedown:function(g){this.handle_touchstart(g)},handle_mousewheel:function(x){this.handleScroll(x,x.wheelDelta/40,x.wheelDelta!==x.wheelDeltaX)},handle_DOMMouseScroll:function(X){this.handleScroll(X,-X.detail,1)},handleScroll:function(y,N,O){var F=this.$22h;X.preventDefault(y),O&&F._41o()&&F.ty(F.ty()+20*N)},handle_mouseup:function(c){this.handle_touchend(c)},handle_touchend:function(_){var E=this;E.$37h(_),E.$26h(_)},handleWindowMouseUp:function(A){this.handleWindowTouchEnd(A)},handleWindowTouchEnd:function(m){var C=this;C.$37h(m),C.$26h(m)},$37h:function(P){var W=this,q=W.$22h;2===W.$35h&&(W.$35h=3,q.handleDragAndDrop(P,"end"))},handleWindowMouseMove:function(f){this.handleWindowTouchMove(f)},handleWindowTouchMove:function(T){var J=this,s=J.$22h,z=J.$23h,H=J.$24h,f=J.$25h,h=X.getClientPoint(T),w=s._29I,C=J.$36h;if(1===J.$35h||2===J.$35h){if(J.$35h=2,s.handleDragAndDrop(T,"between"),g){var q=T.touches[0];T=q?q:T.changedTouches[0]}C.style.left=T.pageX-parseInt(C.width)/2+v,C.style.top=T.pageY-parseInt(C.height)/2+v}else"p"===z?s.ty(f+h.y-H.y):"v"===z&&s.ty(f+(H.y-h.y)/w.height*s._59I)},handle_mousemove:function(U){this.handle_touchmove(U)},handle_touchmove:function(h){if(!X.isDragging()&&X.isLeftButton(h)){var w=this,d=w.$22h,k=w.$27h(h);if(w.$24h){if(!w.$23h){if(X.getDistance(X.getClientPoint(h),w.$24h)<2)return;w.$23h=k?"v":"p",X.startDragging(w)}}else if(k)d._43o();else if(0===w.$35h){if(w.$35h=1,d.handleDragAndDrop(h,"begin"),g){var B=h.touches[0];h=B?B:h.changedTouches[0]}var H=w.$36h=new Image,Y=d.$10h[d.sm().ld().getId()].querySelector(".image-box"),f=parseInt(Y.style.width),i=parseInt(Y.style.height);H.draggable=!1,H.src=Y.toDataURL(),H.width=f,H.height=i,H.style.position="absolute",H.style.left=h.pageX-f/2+v,H.style.top=h.pageY-i/2+v,Z().appendChild(H),X.startDragging(w)}}},$27h:function(k){var m=this.$22h,p=m.getView(),x=p.getBoundingClientRect(),A=m._29I,E=k.clientX-x.left+p.scrollLeft;return m._41o()&&A.x+A.width-E<K}}),ht.widget.Palette=function(f){var w=this,O=w._view=F.createView(null,w);w.$9h={},w.$10h={},w.$4h={},w._29I={x:0,y:0,width:0,height:0},w._59I=0,w.dm(f?f:new ht.DataModel),O[A]="ht-widget-palette",w.$29h=new N(w),G(O,C,X.paletteContentBackground),G(O,E,"auto"),G(O,k,m),G(O,"-moz-"+k,m),G(O,"-webkit-"+Q,P),G(O,"-moz-"+Q,P),G(O,"-ms-"+Q,P),G(O,Q,P),G(O,"position","absolute"),G(O,"overflow","hidden"),a(O,w._79O=d()),n(O,"dragstart",function(Y){Y.dataTransfer&&(Y.dataTransfer.setData("Text","nodeid:"+Y.target.$11h),Y.dataTransfer.effectAllowed="all",w.$29h.$26h())})},c("Palette",x,{ms_v:1,ms_fire:1,ms_dm:1,ms_sm:1,ms_vs:1,ms_ac:["itemImageWidth","itemImageHeight","itemImagePadding","itemMargin","layout","autoHideScrollBar","scrollBarSize","scrollBarColor"],$30h:0,_itemImagePadding:4,_itemImageWidth:70,_itemImageHeight:50,_itemMargin:10,_layout:"largeicons",_autoHideScrollBar:X.autoHideScrollBar,_scrollBarSize:X.scrollBarSize,_scrollBarColor:X.scrollBarColor,getViewRect:function(){return this._29I},ty:function(o){return o?(this.setTranslateY(o),void 0):this.getTranslateY()},setTranslateY:function(y){if(this.$32h==O){var d=this,Z=d.$33h(y),L=d.$30h;d.$30h=Z,d.fp("translateY",L,Z)}},getTranslateY:function(){return this.$30h},setLayout:function(E){var B,h,Y=this,y=Y._layout;Y._layout=E,"smallicons"===E?B=h=20:"iconsonly"===E?B=h=50:(B=70,h=50),Y.setItemImageWidth(B),Y.setItemImageHeight(h),Y.setItemImagePadding(4),Y.fp("layout",y,E)},getDataAt:function(f){for(var P=f.target;P&&P.$11h==O;)P=P.parentNode;return P&&P.$11h!=O?this.getDataModel().getDataById(P.$11h):void 0},$20h:function(){var o=16;return g&&(o*=1.2),o},$19h:function(){return X.paletteTitleHeight},$18h:function(){var i=X.paletteSeparatorWidth,b=X.paletteTitleBackground,l=X.paletteSeparatorColor||X.brighter(b);return i+v+" solid "+l},$17h:function(x){G(x,"cursor","pointer"),G(x,"display","inline-block"),G(x,"margin-right",(g?8:4)+v),G(x,"vertical-align",h)},$1h:function(B){var x=this,L=T(),R=T(),D=Y("span");L[A]="palette-header",G(L,S,"relative"),G(L,C,X.paletteTitleBackground),G(L,"color",X.paletteTitleLabelColor),G(L,h,p),G(L,k,m),G(L,"-moz-"+k,m),G(L,"padding","0 5px 0 0"),G(L,"border-top",x.$18h()),G(L,q,"100%"),G(L,"cursor","pointer"),G(L,"white-space","nowrap"),G(L,E,"hidden"),G(L,M,X.paletteTitleLabelFont),G(L,"line-height",x.$19h()+v),L.$11h=B.getId();var o=z(),O=x.$19h(),e=x.$20h();x.$17h(o),F.setCanvas(o,e,O),a(L,o);var i=B.s("tools");if(i)for(var P=0;P<i.length;P++){var W=z();x.$17h(W),F.setCanvas(W,e,O),W[A]="palette-header-tool palette-header-tool"+B.getId()+"-"+P,W.style.position="absolute",W.style.right=(e+10)*P+"px",W.toolIndex=P,a(L,W)}return o[A]="palette-toggle-icon-"+B.getId(),R[A]="palette-content",G(R,"max-height",0+v),G(R,M,X.paletteContentLabelFont),G(R,E,"hidden"),R.$11h=B.getId(),x.$9h[B.getId()]=R,D[y]=B.getName(),G(D,M,X.paletteTitleLabelFont),a(L,o),a(L,D),[L,R]},$2h:function(H){var k=this,D=k._layout,V=o&&H.s("draggable")?Y("a"):T(),M=z(),q=T(),j=H.getName()||"",t=H.s("title")||H.getToolTip()||j,B=k._itemMargin;M[A]="image-box";var c=k.getItemImageWidth(),Q=k.getItemImageHeight();return F.setCanvas(M,c,Q),a(V,M),q[y]=j,q[A]="label-box","iconsonly"!==D&&a(V,q),V[A]="palette-item",G(V,"vertical-align",h),G(V,"cursor","pointer"),G(V,"border-radius",5+v),G(V,"border","1px solid transparent"),G(V,"text-align","center"),G(V,"display","inline-block"),G(V,"margin-left",B+v),G(V,"margin-top",B+v),G(V,"color",X.paletteContentLabelColor),"smallicons"===D?(G(M,"vertical-align","middle"),G(V,"margin-left",2+v),G(V,"margin-top",2+v),G(V,"padding",2+v),G(V,"text-align",W),G(q,"display","inline-block"),G(q,"min-width",k.$21h+k._itemMargin+v)):"largeicons"===D&&(G(q,"max-width",c+v),G(q,"overflow","hidden")),V.$11h=H.getId(),t&&(V.title=t),H.s("draggable")&&!k.handleDragAndDrop&&(o?(V.href="#",G(V,"text-decoration",P)):V.draggable="true"),V},$16h:function(v,l,k,K){var O=F.initContext(v);F.translateAndScale(O,0,0,1),O.clearRect(0,0,k,k);var d=(k-K)/2;X.drawStretchImage(O,X.getImage(l),"fill",0,d,K,K),O.restore()},$15h:function(S){var o=this,M=S.getId(),D=o._view.querySelector(".palette-toggle-icon-"+M),R=S.isExpanded()?X.paletteCollapseIcon:X.paletteExpandIcon;if(D&&R){var s=o.$19h(),H=o.$20h();o.$16h(D,R,s,H)}},_drawToolsIcon:function(Z){var r=this,g=Z.s("tools");if(g)for(var Y=0;Y<g.length;Y++){var m=r._view.querySelector(".palette-header-tool"+Z.getId()+"-"+Y),f=g[Y].icon,w=r.$19h(),y=r.$20h();r.$16h(m,f,w,y)}},$14h:function(r){var Y=this,c=r.getId(),o=Y.$10h[c].querySelector(".image-box"),W=r.getImage(),K=r.s("image.stretch");if(o&&W){var $=F.initContext(o),N=Y.getItemImagePadding();N="smallicons"===Y._layout?N/2:N;var U=Y.getItemImageWidth()-2*N,v=Y.getItemImageHeight()-2*N;F.translateAndScale($,0,0,1),$.clearRect(0,0,U,v),X.drawStretchImage($,X.getImage(W),K,N,N,U,v,r,Y),$.restore()}},validateImpl:function(){var F,q,C,K=this,h=K.$9h,l=K._layout,G=K.$10h,z=K.$4h,Z=K._view,Q=K.dm();if(K.$13h&&(delete K.$13h,z={},Q.each(function(f){z[f.getId()]=f})),"smallicons"===l)for(var k in z){var S=z[k];if(S instanceof H){var I=S.getName()||"",L=X.getTextSize(X.paletteContentLabelFont,I).width;K.$21h!=O&&K.$21h>L||(K.$21h=L)}}for(var k in z){C=z[k];var R,m;if(Q.contains(C)){if(C instanceof ht.Group){var i,c=K.$1h(C),W=G[C.getId()];W&&(i=W.nextSibling,s(Z,i),s(Z,W)),q=Q.getSiblings(C).indexOf(C);var U=Z.children[2*q]||K._79O;U&&U.parentNode?(Z.insertBefore(c[0],U),Z.insertBefore(i||c[1],U)):(Z.appendChild(c[0]),Z.appendChild(i||c[1])),G[C.getId()]=c[0],F=h[C.getId()]=i||c[1],m=C.$12h;var d=C.s("promptText");m||(C.$12h=Y("div"),C.$12h[y]=d||"",m=C.$12h),0===C.getChildren().size()?F.contains(m)||a(F,m):F.contains(m)&&s(F,m)}else if(R=C.getParent()){var B=K.$2h(C),T=G[C.getId()];F=h[R.getId()],T&&s(T.parentNode,T),q=Q.getSiblings(C).indexOf(C);var g=F.children[q];g?F.insertBefore(B,g):a(F,B),G[C.getId()]=B,K.$14h(C)}}else{var E=G[C.getId()],P=E.parentNode;if(C instanceof ht.Group){var J=E.nextSibling;s(Z,E),s(Z,J),delete h[C.getId()]}else s(P,E),0===P.children.length&&(R=Q.getDataById(P.$11h),m=R.$12h,m&&!P.contains(m)&&a(P,m));delete G[C.getId()]}}K.$4h={};var b=function(){var a=K._59I,r=0;K.$32h!=O&&(clearInterval(K.$32h),r=0,delete K.$32h),K.$32h=setInterval(function(){K.$31h(),a===K._59I?(r++,r>=2&&(clearInterval(K.$32h),delete K.$32h)):(r=0,a=K._59I)},30)};for(var o in h)if(F=h[o],C=Q.getDataById(h[o].$11h),K.$15h(C),K._drawToolsIcon(C),C.isExpanded()){if(F.style.maxHeight===0+v){var u=F.scrollHeight+K._itemMargin+v;V(F).duration(200).set($,u).set("padding-bottom",K._itemMargin+v).end(function(){return function(){b()}}(u))}else F.style.maxHeight=F.scrollHeight+v;F.style.paddingBottom=K._itemMargin+v}else F.style.maxHeight!==0+v&&V(F).duration(200).set($,p).set("padding-bottom",p).end(function(){return function(){b()}}(F));K.$28h(),K.$31h()},$31h:function(){for(var l=this,Q=l._view,C=0,y=Q.children,S=0;S<y.length;S++){var E=y[S];E.className&&E.className.indexOf("palette-")>=0&&(C+=E.offsetHeight)}l._59I=C,l.$30h=l.$33h(l.ty());var $=l.ty();Q.scrollTop=-$,l._29I={x:0,y:-$,width:Q.clientWidth,height:Q.clientHeight},G(l._79O,h,-$+v),l._93I()},$33h:function(Q){var X=this,c=X._29I.height-X._59I;return c>Q&&(Q=c),Q>0?0:Math.round(Q)},redraw:function(){this.$13h||(this.$13h=1,this.iv())},onPropertyChanged:function(J){["autoHideScrollBar","scrollBarSize","scrollBarColor","translateY"].indexOf(J.property)<0&&this.redraw(),"translateY"===J.property&&(this.iv(),this._43o())},findDataByName:function(e){for(var q=this.dm().getDatas(),U=0;U<q.size();U++){var y=q.get(U);if(y.getName()===e)return y}},setDataModel:function(I){var h=this,T=h._dataModel,C=h._selectionModel;T!==I&&(T&&(T.umm(h.$6h,h),T.umd(h.$8h,h),T.umh(h.$7h,h),C||T.sm().ums(h.$28h,h)),h._dataModel=I,I.mm(h.$6h,h),I.md(h.$8h,h),I.mh(h.$7h,h),C?C._21I(I):I.sm().ms(h.$28h,h),h.sm().setSelectionMode("single"),h.fp("dataModel",T,I))},$6h:function(e){var a=this,Y=a._view,p=e.data,W=a.$4h;"add"===e.kind?W[p.getId()]=p:"remove"===e.kind?W[p.getId()]=p:"clear"===e.kind&&(a.$10h={},a.$9h={},a.$4h={},Y[y]=""),a.iv()},$7h:function(Q){var Z=this,y=Q.data;Z.$4h[y.getId()]=y,Z.iv()},$8h:function(r){var n=this,y=r.data,S=r.property;"expanded"===S?n.iv():(n.$4h[y.getId()]=y,n.iv())},$28h:function(){var J,Y=this,D=Y.sm(),v="palette-item",_=D.ld();this.dm().each(function(T){J=Y.$10h[T.getId()],J&&J[A].indexOf(v)>=0&&(T===_?G(J,C,X.paletteItemSelectBackground):r(J,C))})}})}("undefined"!=typeof global?global:"undefined"!=typeof self?self:"undefined"!=typeof window?window:this,Object);