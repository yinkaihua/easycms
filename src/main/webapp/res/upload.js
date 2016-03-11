if (typeof kanglaohui=='undefined') {
	kanglaohui = new Object();
	kanglaohui.addModule = function(name, module) {
		if (!name) {
			throw "module name is empty.";
		}
		if (!kanglaohui[name]) {
			kanglaohui[name] = module;
		}
	}
}
kanglaohui.addModule('widgets.upload', {
	//组件绑定
	bind : function(selector, config) {
		
	}
});
kanglaohui.addModule('widgets.dialog', {});