!function(j,g){"use strict";var L="ht",w=j[L],N=w.Default,p=N.def,I="add",x="remove",e=N.getInternal(),F="propertyChange";w.HistoryManager=function(V){this._histories=[],this.setDataModel(V)},p(w.HistoryManager,g,{ms_ac:["dataModel","histories","historyIndex","maxHistoryCount"],ms_fire:1,_historyIndex:-1,$4p:0,$8p:0,_maxHistoryCount:10,beginInteraction:function(){var r=this;r.$4p++,1===r.$4p&&(r.$3p=[])},endInteraction:function(){var j=this,l=j._histories,Q=j._historyIndex,L=j.$3p;j.$4p>0&&j.$4p--,0===j.$4p&&(delete j.$3p,L&&L.length&&(l=l.slice(0,Q+1),l.push(L),l.length>j._maxHistoryCount&&(l=l.slice(l.length-j._maxHistoryCount)),j.setHistories(l),j.setHistoryIndex(l.length-1,!0)))},beginTransient:function(){this.$4p||this.$8p++},endTransient:function(){this.$4p||this.$8p--},setDataModel:function(W){var X=this,g=X._dataModel;g!==W&&(g&&(delete g._historyManager,g.umm(X.$5p,X),g.umd(X.$6p,X)),X._dataModel=W,W._historyManager=X,W.mm(X.$5p,X),W.md(X.$6p,X),X.fp("dataModel",g,W),X.clear())},setHistoryIndex:function(R,S){var h=this,G=h._historyIndex,g=h._histories.length;if(-1>R?R=-1:R>=g&&(R=g-1),G!==R){if(!S){var Z=R-G;Z>0?h.$2p(Z):0>Z&&h.$1p(-Z)}h._historyIndex=R,h.fp("historyIndex",G,R)}},setMaxHistoryCount:function(n){var R=this,b=R._histories,V=R._maxHistoryCount;(!n||0>=n)&&(n=10),V!==n&&(R._maxHistoryCount=n,R.fp("maxHistoryCount",V,n),b.length>n&&R.clear())},isPropertyRecode:function(){return!0},$5p:function(l){if(!this.$7p&&!this.$8p){var p,Q,z=this,A=z._histories,q=l.kind,W=l.property,X=z._historyIndex;if(q===I||q===x?Q={type:l.kind,data:l.data}:z.isPropertyRecode(W)&&W&&"children"!==W&&"attaches"!==W&&"shape"!==W&&"*"!==W&&(Q={type:F,data:l.data,property:W,oldValue:l.oldValue,newValue:l.newValue}),Q)if(z.$4p){p=z.$3p;var O=!1;if(Q.type===F)for(var w=p.length-1;w>=0;w--){var d=p[w];if(d.type!==F)break;Q.property===d.property&&d.property&&Q.data===d.data&&(Q.oldValue=d.oldValue,p[w]=Q,O=!0)}O||p.push(Q)}else p=[Q],A=A.slice(0,X+1),A.push(p),A.length>z._maxHistoryCount&&(A=A.slice(A.length-z._maxHistoryCount)),z.setHistories(A),z.setHistoryIndex(A.length-1,!0)}},$6p:function(O){this.$5p(O)},undo:function(U){(!U||0>=U)&&(U=1),this.setHistoryIndex(this._historyIndex-U)},$1p:function(d){var y,O=this,z=O._dataModel,G=O._histories,u=O._historyIndex;for(O.$7p=1,N.setIsolating(!0);d>0;){if(u>=0&&u<G.length){y=G[u],u--;for(var K=y.length-1;K>=0;K--){var X=y[K],s=X.type,_=X.data,R=X.property,i=X.oldValue;if(s===I)z.remove(_);else if(s===x)z.add(_);else{var D=null;0===R.indexOf("a:")?(D="attr",R=R.replace("a:","")):0===R.indexOf("s:")&&(D="style",R=R.replace("s:","")),e.setPropertyValue(_,D,R,i)}}}d--}N.setIsolating(!1),delete O.$7p},redo:function(u){(!u||0>=u)&&(u=1),this.setHistoryIndex(this._historyIndex+u)},$2p:function(F){var j,v=this,K=v._dataModel,P=v._histories,u=v._historyIndex;for(v.$7p=1,N.setIsolating(!0);F>0;){if(u>=-1&&u<P.length-1){u++,j=P[u];for(var U=0;U<j.length;U++){var X=j[U],C=X.type,G=X.data,k=X.property,o=X.newValue;if(C===I)K.add(G);else if(C===x)K.remove(G);else{var Y=null;0===k.indexOf("a:")?(Y="attr",k=k.replace("a:","")):0===k.indexOf("s:")&&(Y="style",k=k.replace("s:","")),e.setPropertyValue(G,Y,k,o)}}}F--}N.setIsolating(!1),delete v.$7p},clear:function(){this.setHistories([]),this.setHistoryIndex(-1,!0),this.$4p=0,delete this.$3p}})}("undefined"!=typeof global?global:"undefined"!=typeof self?self:"undefined"!=typeof window?window:this,Object);