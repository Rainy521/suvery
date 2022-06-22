!function(_,k){"use strict";var n="ht",y=n+".layout.",M=_[n]||module.parent.exports.ht,G=M.List,f=M.DataModel,$=M.Node,e=M.Edge,F=M.Group,T=Math,V=T.sqrt,X=T.random,E=T.max,I=T.min,v=function(B){return B*B};M.Default.getInternal().addMSMap({ms_force:function(C){C._interval=50,C._stepCount=10,C._motionLimit=.01,C._edgeRepulsion=.65,C._nodeRepulsion=.65,C._damper=1,C._maxMotion=0,C._motionRatio=0,C.init=function(F){var M=this;F instanceof f?M.dm=F:M.gv=F,M._nodeMap={},M._nodes=new G,M._edges=new G},C.start=function(){var b=this,L=b.gv;if(!b._timer){var R=b.cdm=L?L.dm():b.dm;R.mm(b.handleDataModelChange,b),R.md(b.handleDataPropertyChange,b),L&&L.mp(b.handleGV,b),R.each(function(D){if(b.isVisible(D)&&b.isLayoutable(D)&&D instanceof $)if(b instanceof Z){var T=D.p3();D.p3([T[0]+X(),T[1]+X(),T[2]+X()])}else T=D.p(),D.p(T.x+X(),T.y+X())}),b._timer=setInterval(function(){b.relax()},b._interval),b._damper=1}},C.stop=function(){var H=this;H._timer&&(H.cdm.umm(H.handleDataModelChange,H),H.cdm.umd(H.handleDataPropertyChange,H),H.gv&&H.gv.ump(H.handleGV,H),clearInterval(H._timer),delete H._timer,delete H.cdm)},C.handleGV=function(l){var A=this;if("dataModel"===l.property){var g=l.oldValue,M=l.newValue;g&&(g.umm(A.handleDataModelChange,A),g.umd(A.handleDataPropertyChange,A)),this.cdm=M,M.mm(A.handleDataModelChange,A),M.md(A.handleDataPropertyChange,A)}},C.relax=function(){var M=this;if(!(M._damper<.1&&M._maxMotion<M._motionLimit)){this.cdm.each(function(V){M.isVisible(V)&&(V instanceof e?M.addEdge(V):V instanceof $&&M.addNode(V))});for(var p,i,H=0,u=M._edges,C=M._nodes,L=C.size();H<M._stepCount;H++){for(u.each(M.relaxEdge,M),p=0;L>p;p++)for(i=0;L>i;i++)M.relaxNode(C.get(p),C.get(i));M.moveNode()}M._isAdjusting=1,C.each(function(m){m.fix||(m.p?m.v.p3(m.p):m.v.p(m.x,m.y))}),delete M._isAdjusting,M._nodeMap={},C.clear(),u.clear(),M.onRelaxed()}},C.onRelaxed=function(){},C.isRunning=function(){return!!this._timer},C.isVisible=function(q){return q.s("layoutable")===!1?!1:this.gv?this.gv.isVisible(q):!0},C.isLayoutable=function(r){if(r.s("layoutable")===!1)return!1;if(r instanceof F)return!1;var U=this;return U.gv?U.gv.isMovable(r)&&!U.gv.isSelected(r):!(U.cdm||U.dm).sm().co(r)},C.getNodeRepulsion=function(){return this._nodeRepulsion},C.setNodeRepulsion=function(D){this._nodeRepulsion=D,this._damper=1},C.getEdgeRepulsion=function(){return this._edgeRepulsion},C.setEdgeRepulsion=function(r){this._edgeRepulsion=r,this._damper=1},C.getStepCount=function(){return this._stepCount},C.setStepCount=function(D){this._stepCount=D,this._damper=1},C.getInterval=function(){return this._interval},C.setInterval=function(V){var y=this;y._interval!==V&&(y._interval=V,y._timer&&(clearInterval(y._timer),y._timer=setInterval(function(){y.relax()},V)))},C.handleDataPropertyChange=function(L){!this._isAdjusting&&this.isVisible(L.data)&&(this._damper=1)},C.handleDataModelChange=function(){this._damper=1},C.damp=function(){var L=this._maxMotion,t=this._damper;this._motionRatio<=.001&&((.2>L||L>1&&.9>t)&&t>.01?this._damper-=.01:.4>L&&t>.003?this._damper-=.003:t>1e-4&&(this._damper-=1e-4)),L<this._motionLimit&&(this._damper=0)}}}),M.layout.ForceLayout=function(h){this.init(h)},M.Default.def(y+"ForceLayout",k,{ms_force:1,getLimitBounds:function(){return this._limitBounds},setLimitBounds:function(g){this._limitBounds=g,this._damper=1},getNodeSize:function(b){var d=this.gv;return d&&d.getDataUIBounds?d.getDataUIBounds(b):b.getRect()},addNode:function(W){var N=this,y=N._nodeMap[W._id];if(y)return y;var l=W.p();y={v:W,x:l.x,y:l.y,dx:0,dy:0,fix:!N.isLayoutable(W),s:N.getNodeSize(W)};var n=y.s,m=V(v(n.width)+v(n.height))*N._nodeRepulsion;return y.r=1>m?100:m,N._nodeMap[W._id]=y,N._nodes.add(y),y},addEdge:function(E){if(E._40I&&E._41I){var K=this,T=K.addNode(E._40I),g=K.addNode(E._41I),X={s:T,t:g};g=g.s,T=T.s;var P=g.width+T.width,u=g.height+T.height;X.length=V(P*P+u*u)*K._edgeRepulsion,X.length<=0&&(X.length=100),K._edges.add(X)}},relaxEdge:function(h){var Q=h.t,l=h.s,Z=Q.x-l.x,I=Q.y-l.y,J=V(Z*Z+I*I),r=100*h.length,$=.25*Z/r*J,g=.25*I/r*J;Q.dx=Q.dx-$,Q.dy=Q.dy-g,l.dx=l.dx+$,l.dy=l.dy+g},relaxNode:function(j,b){if(j!==b){var V=0,i=0,d=j.x-b.x,S=j.y-b.y,T=d*d+S*S;0===T?(V=X(),i=X()):36e4>T&&(V=d/T,i=S/T);var w=j.r*b.r/400;V*=w,i*=w,j.dx+=V,j.dy+=i,b.dx-=V,b.dy-=i}},moveNode:function(){var Y=this,K=Y._limitBounds,z=Y._maxMotion,Q=0,W=Y._damper;Y._nodes.each(function(y){if(!y.fix){var C=y.dx*W,q=y.dy*W;if(y.dx=C/2,y.dy=q/2,Q=E(V(C*C+q*q),Q),y.x+=E(-40,I(40,C)),y.y+=E(-40,I(40,q)),K){y.x<K.x&&(y.x=K.x,Y.adjust(1,0)),y.y<K.y&&(y.y=K.y,Y.adjust(0,1));var o=y.s;y.x+o.width>K.x+K.width&&(y.x=K.x+K.width-o.width,Y.adjust(-1,0)),y.y+o.height>K.y+K.height&&(y.y=K.y+K.height-o.height,Y.adjust(0,-1))}}}),Y._maxMotion=Q,Y._motionRatio=Q>0?z/Q-1:0,Y.damp()},adjust:function(R,Y){var m=this._limitBounds;this._nodes.each(function(k){R>0?(!m||k.x+k.s.width+R<m.x+m.width)&&(k.x+=R):(!m||k.x+R>m.x)&&(k.x+=R),Y>0?(!m||k.y+k.s.height+Y<m.y+m.height)&&(k.y+=Y):(!m||k.y+Y>m.y)&&(k.y+=Y)})}});var Z=M.layout.Force3dLayout=function(w){this.init(w)};M.Default.def(y+"Force3dLayout",k,{ms_force:1,getNodeSize3d:function(z){return z.s3()},addNode:function(x){var Y=this,U=Y._nodeMap[x._id];if(U)return U;U={v:x,p:x.p3(),d:[0,0,0],fix:!Y.isLayoutable(x),s:Y.getNodeSize3d(x)};var B=U.s,i=M.Default.getDistance(B)*Y._nodeRepulsion;return U.r=1>i?100:i,Y._nodeMap[x._id]=U,Y._nodes.add(U),U},addEdge:function(c){if(c._40I&&c._41I){var G=this,e=G.addNode(c._40I),C=G.addNode(c._41I),p={s:e,t:C};C=C.s,e=e.s,p.length=V(v(C[0]+e[0])+v(C[1]+e[1])+v(C[2]+e[2]))*G._edgeRepulsion,p.length<=0&&(p.length=100),G._edges.add(p)}},relaxEdge:function(h){var S=h.t.p,H=h.s.p,z=h.t.d,g=h.s.d,b=S[0]-H[0],k=S[1]-H[1],$=S[2]-H[2],m=V(b*b+k*k+$*$),t=100*h.length,W=.25*b/t*m,P=.25*k/t*m,j=.25*$/t*m;z[0]-=W,z[1]-=P,z[2]-=j,g[0]+=W,g[1]+=P,g[2]+=j},relaxNode:function(m,S){if(m!==S){var A=m.p,l=S.p,L=0,y=0,N=0,K=A[0]-l[0],z=A[1]-l[1],I=A[2]-l[2],B=K*K+z*z+I*I;0===B?(L=X(),y=X(),N=X()):216e6>B&&(L=K/B,y=z/B,N=I/B);var u=m.r*S.r/400,G=m.d,U=S.d;L*=u,y*=u,N*=u,G[0]+=L,G[1]+=y,G[2]+=N,U[0]-=L,U[1]-=y,U[2]-=N}},moveNode:function(){var w=this,P=w._maxMotion,u=0,T=w._damper;w._nodes.each(function(Z){if(!Z.fix){var O=Z.p,c=Z.d,v=c[0]*T,x=c[1]*T,G=c[2]*T;c[0]=v/2,c[1]=x/2,c[2]=G/2,u=E(V(v*v+x*x+G*G),u),O[0]+=E(-40,I(40,v)),O[1]+=E(-40,I(40,x)),O[2]+=E(-40,I(40,G))}}),w._maxMotion=u,w._motionRatio=u>0?P/u-1:0,w.damp()}})}("undefined"!=typeof global?global:"undefined"!=typeof self?self:"undefined"!=typeof window?window:this,Object);