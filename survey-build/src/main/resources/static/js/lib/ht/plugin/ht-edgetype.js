!function(S){"use strict";var d="ht",Y=S[d],T=Math,J=T.max,x=T.min,I=T.abs,e=T.atan2,a=T.cos,f=T.sin,R=T.ceil,g=Y.Default,y=g.getInternal(),X=Y.List,r=y.Mat,j=y.getNodeRect,C=y.intersectionLineRect,H=g.getDistance,W=g.setEdgeType,h="left",o="right",F="top",q="bottom",s="edge.type",V="edge.gap",t="edge.center",w="edge.extend",_=function(H,h){return j(H,h).width},M=function(C,h){return j(C,h).height},u=function(z,U){return y.getEdgeAgentPosition(z,U._40I,U.s("edge.source.position"),U.s("edge.source.offset.x"),U.s("edge.source.offset.y"),U.s("edge.source.anchor.x"),U.s("edge.source.anchor.y"))},D=function(q,r){return y.getEdgeAgentPosition(q,r._41I,r.s("edge.target.position"),r.s("edge.target.offset.x"),r.s("edge.target.offset.y"),r.s("edge.target.anchor.x"),r.s("edge.target.anchor.y"))},k=function(Q,O){var v=Q.s(s),c=Q.getEdgeGroup();if(c){var U=0;if(c.eachSiblingEdge(function(K){O.isVisible(K)&&K.s(s)==v&&U++}),U>1)return Q.s(V)*(U-1)/2}return 0},l=function(m,C){var B=m.s(s),e=m.isLooped();if(!m.getEdgeGroup())return e?m.s(V):0;var $,X=0,G=0,U=0;return m.getEdgeGroup().getSiblings().each(function(t){t.each(function(K){if(K._40I===m._40I&&K.s(s)==B&&C.isVisible(K)){var h=K.s(V);$?(G+=U/2+h/2,U=h):($=K,U=h),K===m&&(X=G)}})}),e?G-X+U:X-G/2},c=function(z,$){var _=z.size(),W=$.s("edge.corner.radius");if(0===W)return{points:z,segments:new X([1,_])};if(0>W)return{points:z};var P,O=new X,c=new X,u=z.get(0);O.add(u),c.add(1);for(var k=1;_>k;k++)if(_>k+1){var Z=z.get(k),n=z.get(k+1),C=u.x,v=u.y,w=Z.x,D=Z.y,R=D-v,t=w-C,Q=e(R,t);P=x(.99*H(u,Z),W),O.add({x:w-P*a(Q),y:D-P*f(Q)}),O.add(Z),C=Z.x,v=Z.y,w=n.x,D=n.y,R=D-v,t=w-C,Q=e(R,t),P=x(.99*H(Z,n),W),u={x:C+P*a(Q),y:v+P*f(Q)},O.add(u),c.addAll([2,3])}else O.add(z.get(k)),c.add(2);return{points:O,segments:c}};y.addMethod(Y.Style,{"edge.ripple.elevation":-20,"edge.ripple.size":1,"edge.ripple.both":!1,"edge.ripple.straight":!1,"edge.ripple.length":-1,"edge.corner.radius":-1,"edge.ortho":.5,"edge.flex":20,"edge.extend":20},!0),W("boundary",function(h,f,T,E){E||(f=-f);var V,$=u(T,h),M=D(T,h),g=j(T,h._40I),O=j(T,h._41I),w=new r(e(M.y-$.y,M.x-$.x)),x=H($,M),F=$.x,q=$.y;return V=w.tf(0,f),$={x:V.x+F,y:V.y+q},V=w.tf(x,f),M={x:V.x+F,y:V.y+q},V=C($,M,g),V&&($={x:V[0],y:V[1]}),V=C($,M,O),V&&(M={x:V[0],y:V[1]}),{points:new X([$,M])}}),W("ripple",function(O,K,q,S){S||(K=-K);var V=u(q,O),C=D(q,O),P=H(V,C),Y=x(O.s("edge.offset"),P/2),B=O.s("edge.ripple.size"),f=O.s("edge.ripple.length"),W=O.s("edge.ripple.both"),n=O.s(t),l=O.s("edge.ripple.elevation"),F=new X,j=O.s("edge.ripple.straight")?null:new X,v=new r(e(C.y-V.y,C.x-V.x));S||(l=-l),P-=2*Y,f>0&&(B=R(P/f));var $=P/B;j&&j.add(1);for(var L=0;B>L;L++)j&&j.add(3),0===L?F.add({x:Y+$*L,y:n?0:K}):F.add({x:Y+$*L,y:K}),F.add({x:Y+$*L+$/2,y:l+K}),W&&(l=-l);for(F.add({x:Y+P,y:n?0:K}),L=0;L<F.size();L++){var J=v.tf(F.get(L));J.x+=V.x,J.y+=V.y,F.set(L,J)}return{points:F,segments:j}}),W("h.v",function(i,x,H){x=l(i,H);var f=new X,J=i.s(t),w=u(H,i),z=w.x,I=w.y,Y=D(H,i),y=Y.x,B=Y.y,k=0,N=0,F=y-z,W=B-I;return J||(k=_(H,i._40I)/2,N=M(H,i._41I)/2),F>=0&&0>=W?(f.add({x:z+k,y:I+x}),f.add({x:y+x,y:I+x}),f.add({x:y+x,y:B+N})):0>=F&&W>=0?(f.add({x:z-k,y:I+x}),f.add({x:y+x,y:I+x}),f.add({x:y+x,y:B-N})):F>=0&&W>=0?(f.add({x:z+k,y:I+x}),f.add({x:y-x,y:I+x}),f.add({x:y-x,y:B-N})):(f.add({x:z-k,y:I+x}),f.add({x:y-x,y:I+x}),f.add({x:y-x,y:B+N})),c(f,i)}),W("v.h",function(Q,k,T){k=l(Q,T);var O=new X,U=Q.s(t),F=u(T,Q),P=F.x,K=F.y,W=D(T,Q),o=W.x,g=W.y,A=0,h=0,s=o-P,H=g-K;return U||(A=_(T,Q._41I)/2,h=M(T,Q._40I)/2),s>=0&&0>=H?(O.add({x:P+k,y:K-h}),O.add({x:P+k,y:g+k}),O.add({x:o-A,y:g+k})):0>=s&&H>=0?(O.add({x:P+k,y:K+h}),O.add({x:P+k,y:g+k}),O.add({x:o+A,y:g+k})):s>=0&&H>=0?(O.add({x:P-k,y:K+h}),O.add({x:P-k,y:g+k}),O.add({x:o-A,y:g+k})):(O.add({x:P-k,y:K-h}),O.add({x:P-k,y:g+k}),O.add({x:o+A,y:g+k})),c(O,Q)}),W("ortho",function(i,o,d){var R=new X,V=i.s(t),E=i.s("edge.ortho"),F=i._40I,Y=i._41I,Z=u(d,i),n=Z.x,g=Z.y,p=D(d,i),S=p.x,Q=p.y,l=S-n,y=Q-g,H=V?0:_(d,F)/2,A=V?0:M(d,F)/2,K=V?0:_(d,Y)/2,v=V?0:M(d,Y)/2,U=(l-(H+K)*(l>0?1:-1))*E,P=(y-(A+v)*(y>0?1:-1))*E;return I(l)<I(y)?l>=0&&0>=y?(R.add({x:n+o,y:g-A}),R.add({x:n+o,y:g+P+o-A}),R.add({x:S+o,y:g+P+o-A}),R.add({x:S+o,y:Q+v})):0>=l&&y>=0?(R.add({x:n+o,y:g+A}),R.add({x:n+o,y:g+P+o+A}),R.add({x:S+o,y:g+P+o+A}),R.add({x:S+o,y:Q-v})):l>=0&&y>=0?(R.add({x:n+o,y:g+A}),R.add({x:n+o,y:g+P-o+A}),R.add({x:S+o,y:g+P-o+A}),R.add({x:S+o,y:Q-v})):(R.add({x:n+o,y:g-A}),R.add({x:n+o,y:g+P-o-A}),R.add({x:S+o,y:g+P-o-A}),R.add({x:S+o,y:Q+v})):l>=0&&0>=y?(R.add({x:n+H,y:g+o}),R.add({x:n+U+o+H,y:g+o}),R.add({x:n+U+o+H,y:Q+o}),R.add({x:S-K,y:Q+o})):0>=l&&y>=0?(R.add({x:n-H,y:g+o}),R.add({x:n+U+o-H,y:g+o}),R.add({x:n+U+o-H,y:Q+o}),R.add({x:S+K,y:Q+o})):l>=0&&y>=0?(R.add({x:n+H,y:g+o}),R.add({x:n+U-o+H,y:g+o}),R.add({x:n+U-o+H,y:Q+o}),R.add({x:S-K,y:Q+o})):(R.add({x:n-H,y:g+o}),R.add({x:n+U-o-H,y:g+o}),R.add({x:n+U-o-H,y:Q+o}),R.add({x:S+K,y:Q+o})),c(R,i)}),W("flex",function(q,$,L){var s=new X,f=q.s("edge.flex")+k(q,L),Y=q.s(t),x=q._40I,R=q._41I,w=u(L,q),A=w.x,l=w.y,Z=D(L,q),b=Z.x,C=Z.y,m=b-A,S=C-l,N=Y?0:_(L,x)/2,E=Y?0:M(L,x)/2,p=Y?0:_(L,R)/2,o=Y?0:M(L,R)/2,j=m>0?f:-f,Q=S>0?f:-f;return I(m)<I(S)?m>=0&&0>=S?(s.add({x:A+$,y:l-E}),s.add({x:A+$,y:l+Q+$-E}),s.add({x:b+$,y:C-Q+$+o}),s.add({x:b+$,y:C+o})):0>=m&&S>=0?(s.add({x:A+$,y:l+E}),s.add({x:A+$,y:l+Q+$+E}),s.add({x:b+$,y:C-Q+$-o}),s.add({x:b+$,y:C-o})):m>=0&&S>=0?(s.add({x:A+$,y:l+E}),s.add({x:A+$,y:l+Q-$+E}),s.add({x:b+$,y:C-Q-$-o}),s.add({x:b+$,y:C-o})):(s.add({x:A+$,y:l-E}),s.add({x:A+$,y:l+Q-$-E}),s.add({x:b+$,y:C-Q-$+o}),s.add({x:b+$,y:C+o})):m>=0&&0>=S?(s.add({x:A+N,y:l+$}),s.add({x:A+j+$+N,y:l+$}),s.add({x:b-j+$-p,y:C+$}),s.add({x:b-p,y:C+$})):0>=m&&S>=0?(s.add({x:A-N,y:l+$}),s.add({x:A+j+$-N,y:l+$}),s.add({x:b-j+$+p,y:C+$}),s.add({x:b+p,y:C+$})):m>=0&&S>=0?(s.add({x:A+N,y:l+$}),s.add({x:A+j-$+N,y:l+$}),s.add({x:b-j-$-p,y:C+$}),s.add({x:b-p,y:C+$})):(s.add({x:A-N,y:l+$}),s.add({x:A+j-$-N,y:l+$}),s.add({x:b-j-$+p,y:C+$}),s.add({x:b+p,y:C+$})),c(s,q)}),W("extend.east",function(g,N,Q){var f=new X,q=g.s(w)+k(g,Q),A=g.s(t),Z=u(Q,g),B=Z.x+(A?0:_(Q,g._40I)/2),j=Z.y,o=D(Q,g),S=o.x+(A?0:_(Q,g._41I)/2),n=o.y,e=J(B,S)+q;return j>n?(f.add({x:B,y:j+N}),f.add({x:e+N,y:j+N}),f.add({x:e+N,y:n-N}),f.add({x:S,y:n-N})):(f.add({x:B,y:j-N}),f.add({x:e+N,y:j-N}),f.add({x:e+N,y:n+N}),f.add({x:S,y:n+N})),c(f,g)}),W("extend.west",function(N,G,z){var C=new X,M=N.s(w)+k(N,z),H=N.s(t),S=u(z,N),g=S.x-(H?0:_(z,N._40I)/2),h=S.y,V=D(z,N),i=V.x-(H?0:_(z,N._41I)/2),y=V.y,A=x(g,i)-M;return h>y?(C.add({x:g,y:h+G}),C.add({x:A-G,y:h+G}),C.add({x:A-G,y:y-G}),C.add({x:i,y:y-G})):(C.add({x:g,y:h-G}),C.add({x:A-G,y:h-G}),C.add({x:A-G,y:y+G}),C.add({x:i,y:y+G})),c(C,N)}),W("extend.north",function(h,H,d){var Q=new X,l=h.s(w)+k(h,d),U=h.s(t),f=u(d,h),j=f.x,$=f.y-(U?0:M(d,h._40I)/2),A=D(d,h),g=A.x,K=A.y-(U?0:M(d,h._41I)/2),E=x($,K)-l;return j>g?(Q.add({y:$,x:j+H}),Q.add({y:E-H,x:j+H}),Q.add({y:E-H,x:g-H}),Q.add({y:K,x:g-H})):(Q.add({y:$,x:j-H}),Q.add({y:E-H,x:j-H}),Q.add({y:E-H,x:g+H}),Q.add({y:K,x:g+H})),c(Q,h)}),W("extend.south",function(_,H,G){var Z=new X,C=_.s(w)+k(_,G),y=_.s(t),e=u(G,_),O=e.x,j=e.y+(y?0:M(G,_._40I)/2),V=D(G,_),q=V.x,v=V.y+(y?0:M(G,_._41I)/2),g=J(j,v)+C;return O>q?(Z.add({y:j,x:O+H}),Z.add({y:g+H,x:O+H}),Z.add({y:g+H,x:q-H}),Z.add({y:v,x:q-H})):(Z.add({y:j,x:O-H}),Z.add({y:g+H,x:O-H}),Z.add({y:g+H,x:q+H}),Z.add({y:v,x:q+H})),c(Z,_)});var B=function(i,R,S,q,W){if(q.sort(function(f,C){var X=f.getSourceAgent()===R?f.getTargetAgent():f.getSourceAgent(),q=C.getSourceAgent()===R?C.getTargetAgent():C.getSourceAgent(),x=X.p(),D=q.p();if(S===h||S===o){if(x.y>D.y)return 1;if(x.y<D.y)return-1}else{if(x.x>D.x)return 1;if(x.x<D.x)return-1}return g.sortFunc(f.getId(),C.getId())}),W){for(var H,I,O,w=i.getSourceAgent(),M=i.getTargetAgent(),C=0;C<q.size();C++){var j=q.get(C);j.getSourceAgent()===w&&j.getTargetAgent()===M||j.getTargetAgent()===w&&j.getSourceAgent()===M?(I||(I=new X),I.add(j,0)):I?(O||(O=new X),O.add(j)):(H||(H=new X),H.add(j))}q.clear(),H&&q.addAll(H),I&&q.addAll(I),O&&q.addAll(O)}var m=q.indexOf(i),r=q.size(),Q=i.s(V);return{side:S,index:m,size:r,offset:-Q*(r-1)/2+Q*m}},Z=function(q,L,l,Q,u){var N=L.s(s);return B(L,l,Q,l.getAgentEdges().toList(function(D){return q.isVisible(D)&&D.s(s)===N}),u)},O=function(i,v){var C=i.getSourceAgent()===v?i.getTargetAgent():i.getSourceAgent(),R=v.p(),L=C.p(),$=L.x-R.x,B=L.y-R.y;return $>0&&I(B)<=$?o:0>$&&I(B)<=-$?h:B>0&&I($)<=B?q:F},K=function(y,I,_){var l=I.s(s),t=O(I,_);return B(I,_,t,_.getAgentEdges().toList(function(Y){return y.isVisible(Y)&&Y.s(s)===l&&O(Y,_)===t}))},Q=function(V,v){var e=V.getSourceAgent()===v,H=e?V.getTargetAgent():V.getSourceAgent(),t=v.p(),D=H.p();return e?t.y>D.y?F:q:t.x<D.x?o:h},U=function(r,R,g){var N=R.s(s),T=Q(R,g);return B(R,g,T,g.getAgentEdges().toList(function(C){return r.isVisible(C)&&C.s(s)===N&&Q(C,g)===T}),T===o||T===q)},N=function(v,n){var E=v.getSourceAgent()===n,p=E?v.getTargetAgent():v.getSourceAgent(),b=n.p(),u=p.p();return E?b.x<u.x?o:h:b.y>u.y?F:q},p=function(m,U,H){var v=U.s(s),V=N(U,H);return B(U,H,V,H.getAgentEdges().toList(function(R){return m.isVisible(R)&&R.s(s)===v&&N(R,H)===V}),V===o||V===q)},v=function(C,G,Q){var m=C.getSourceAgent(),y=C.getTargetAgent(),g=m.getId()>y.getId(),B=g?y:m,J=g?m:y,H=B.p(),p=J.p(),b=Q(G,C,B),R=Q(G,C,J),a=C.s(t),W=a?0:_(G,B)/2,f=a?0:_(G,J)/2,D=a?0:M(G,B)/2,w=a?0:M(G,J)/2,A=b.offset,$=R.offset,j=b.side,V=R.side,u=new X;return j===F?(u.add({x:H.x+A,y:H.y-D}),u.add({x:H.x+A,y:p.y+$}),V===h?u.add({x:p.x-f,y:p.y+$}):u.add({x:p.x+f,y:p.y+$})):j===q?(u.add({x:H.x+A,y:H.y+D}),u.add({x:H.x+A,y:p.y+$}),V===h?u.add({x:p.x-f,y:p.y+$}):u.add({x:p.x+f,y:p.y+$})):j===h?(u.add({x:H.x-W,y:H.y+A}),u.add({x:p.x+$,y:H.y+A}),V===q?u.add({x:p.x+$,y:p.y+w}):u.add({x:p.x+$,y:p.y-w})):j===o&&(u.add({x:H.x+W,y:H.y+A}),u.add({x:p.x+$,y:H.y+A}),V===q?u.add({x:p.x+$,y:p.y+w}):u.add({x:p.x+$,y:p.y-w})),g&&u.reverse(),c(u,C)};W("ortho2",function(J,l,y){var T,O,m=J.s(t),v=J.s("edge.ortho"),R=J.getSourceAgent(),V=J.getTargetAgent(),Y=R.getId()>V.getId(),L=Y?V:R,D=Y?R:V,Q=L.p(),j=D.p(),N=K(y,J,L),U=K(y,J,D),p=m?0:_(y,L)/2,e=m?0:M(y,L)/2,g=m?0:_(y,D)/2,b=m?0:M(y,D)/2,w=new X,u=N.offset,P=U.offset,$=N.side;return $===o?(T=j.y>Q.y?-u:u,O=Q.x+p+(j.x-g-Q.x-p)*v,w.add({x:Q.x+p,y:Q.y+u}),w.add({x:O+T,y:Q.y+u}),w.add({x:O+T,y:j.y+P}),w.add({x:j.x-g,y:j.y+P})):$===h?(T=j.y>Q.y?-u:u,O=Q.x-p-(Q.x-p-j.x-g)*v,w.add({x:Q.x-p,y:Q.y+u}),w.add({x:O-T,y:Q.y+u}),w.add({x:O-T,y:j.y+P}),w.add({x:j.x+g,y:j.y+P})):$===q?(T=j.x>Q.x?-u:u,O=Q.y+e+(j.y-b-Q.y-e)*v,w.add({x:Q.x+u,y:Q.y+e}),w.add({x:Q.x+u,y:O+T}),w.add({x:j.x+P,y:O+T}),w.add({x:j.x+P,y:j.y-b})):$===F&&(T=j.x>Q.x?-u:u,O=Q.y-e-(Q.y-e-j.y-b)*v,w.add({x:Q.x+u,y:Q.y-e}),w.add({x:Q.x+u,y:O-T}),w.add({x:j.x+P,y:O-T}),w.add({x:j.x+P,y:j.y+b})),Y&&w.reverse(),c(w,J)},!0),W("flex2",function(y,b,p){var D,v=y.getSourceAgent(),S=y.getTargetAgent(),r=v.getId()>S.getId(),R=r?S:v,i=r?v:S,Q=R.p(),T=i.p(),$=K(p,y,R),Z=K(p,y,i),m=y.s(t),u=y.s("edge.flex")+($.size-1)/2*y.s(V),W=m?0:_(p,R)/2,z=m?0:M(p,R)/2,e=m?0:_(p,i)/2,P=m?0:M(p,i)/2,Y=new X,O=$.offset,E=Z.offset,B=$.side;return B===o?(D=T.y>Q.y?-O:O,Y.add({x:Q.x+W,y:Q.y+O}),Y.add({x:Q.x+W+u+D,y:Q.y+O}),Y.add({x:T.x-e-u+D,y:T.y+E}),Y.add({x:T.x-e,y:T.y+E})):B===h?(D=T.y>Q.y?-O:O,Y.add({x:Q.x-W,y:Q.y+O}),Y.add({x:Q.x-W-u-D,y:Q.y+O}),Y.add({x:T.x+e+u-D,y:T.y+E}),Y.add({x:T.x+e,y:T.y+E})):B===q?(D=T.x>Q.x?-O:O,Y.add({x:Q.x+O,y:Q.y+z}),Y.add({x:Q.x+O,y:Q.y+z+u+D}),Y.add({x:T.x+E,y:T.y-P-u+D}),Y.add({x:T.x+E,y:T.y-P})):B===F&&(D=T.x>Q.x?-O:O,Y.add({x:Q.x+O,y:Q.y-z}),Y.add({x:Q.x+O,y:Q.y-z-u-D}),Y.add({x:T.x+E,y:T.y+P+u-D}),Y.add({x:T.x+E,y:T.y+P})),r&&Y.reverse(),c(Y,y)},!0),W("extend.north2",function(D,L,q){var T=D.getSourceAgent(),J=D.getTargetAgent(),b=T.getId()>J.getId(),N=b?J:T,y=b?T:J,j=N.p(),I=y.p(),Q=Z(q,D,N,F),r=Z(q,D,y,F,!0),E=D.s(t),d=E?0:M(q,N)/2,m=E?0:M(q,y)/2,O=Q.offset,Y=r.offset,W=D.s(w)+(Q.size-1)/2*D.s(V),l=x(j.y-d,I.y-m)-W+(j.x<I.x?O:-O),z=new X;return z.add({x:j.x+O,y:j.y-d}),z.add({x:j.x+O,y:l}),z.add({x:I.x+Y,y:l}),z.add({x:I.x+Y,y:I.y-m}),b&&z.reverse(),c(z,D)},!0),W("extend.south2",function(E,h,K){var x=E.getSourceAgent(),L=E.getTargetAgent(),d=x.getId()>L.getId(),l=d?L:x,v=d?x:L,Q=l.p(),F=v.p(),D=Z(K,E,l,q),S=Z(K,E,v,q,!0),z=E.s(t),r=z?0:M(K,l)/2,m=z?0:M(K,v)/2,n=D.offset,u=S.offset,N=E.s(w)+(D.size-1)/2*E.s(V),y=J(Q.y+r,F.y+m)+N+(Q.x>F.x?n:-n),P=new X;return P.add({x:Q.x+n,y:Q.y+r}),P.add({x:Q.x+n,y:y}),P.add({x:F.x+u,y:y}),P.add({x:F.x+u,y:F.y+m}),d&&P.reverse(),c(P,E)},!0),W("extend.west2",function(P,G,l){var e=P.getSourceAgent(),h=P.getTargetAgent(),R=e.getId()>h.getId(),D=R?h:e,O=R?e:h,N=D.p(),u=O.p(),Q=Z(l,P,D,F),E=Z(l,P,O,F,!0),o=P.s(t),m=o?0:_(l,D)/2,$=o?0:_(l,O)/2,j=Q.offset,r=E.offset,d=P.s(w)+(Q.size-1)/2*P.s(V),C=x(N.x-m,u.x-$)-d+(N.y<u.y?j:-j),T=new X;return T.add({x:N.x-m,y:N.y+j}),T.add({x:C,y:N.y+j}),T.add({x:C,y:u.y+r}),T.add({x:u.x-$,y:u.y+r}),R&&T.reverse(),c(T,P)},!0),W("extend.east2",function(H,g,K){var T=H.getSourceAgent(),l=H.getTargetAgent(),x=T.getId()>l.getId(),O=x?l:T,r=x?T:l,Y=O.p(),n=r.p(),A=Z(K,H,O,F),j=Z(K,H,r,F,!0),y=H.s(t),L=y?0:_(K,O)/2,I=y?0:_(K,r)/2,e=A.offset,R=j.offset,U=H.s(w)+(A.size-1)/2*H.s(V),k=J(Y.x+L,n.x+I)+U+(Y.y>n.y?e:-e),v=new X;return v.add({x:Y.x+L,y:Y.y+e}),v.add({x:k,y:Y.y+e}),v.add({x:k,y:n.y+R}),v.add({x:n.x+I,y:n.y+R}),x&&v.reverse(),c(v,H)},!0),W("v.h2",function(N,Q,H){return v(N,H,U)},!0),W("h.v2",function(R,f,b){return v(R,b,p)},!0)}("undefined"!=typeof global?global:"undefined"!=typeof self?self:"undefined"!=typeof window?window:this,Object);