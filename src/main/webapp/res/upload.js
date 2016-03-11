if (typeof $=='undefined') {
	throw 'Need JQuery.';
}

kanglaohui = {};
kanglaohui.widgets = {};
kanglaohui.widgets.upload = function(selector, container, config) {
	this.selectorCheck(selector);
	this.setAttribute('action', config);
//	this.
};
kanglaohui.widgets.upload.prototype = {
	selectorCheck : function(selector) {
		if ($(selector).attr('type')!='file') {
			throw '绑定的元素不是input[file].';
		}
	},
	setAttribute : function(attr, config) {
		if (!config[attr]) {
			throw attr+'未指定.';
		}
		this[attr] = config[attr];
	},
	bind : function(container) {
		var formHtml = '<form method="post" enctype="multipart/form-data" action="'+this.action+'">';
		formHtml+=$(container).html()+'</form>';
		
	}
};

/*if (typeof kanglaohui=='undefined') {
	kanglaohui = new Object();
	kanglaohui.addModule = function(name, construct) {
		if (!name) {
			throw 'module name is empty.';
		}
		if (!kanglaohui[name]) {
			kanglaohui[name] = construct;
		}
	}
}
kanglaohui.addModule('widgets.upload', function(id) {
	
});
kanglaohui['widgets.upload'].prototype = {
	bind : function(selector, config) {
		this.selectorCheck(selector);
		this.setAttribute('action', config);
	},
	selectorCheck : function(selector) {
		if ($('selector').attr('type')!='file') {
			throw '绑定的元素不是input[file].';
		}
	},
	setAttribute : function(attr, config) {
		if (!config[attr]) {
			throw attr+'未指定.';
		}
	}
};*/
/*kanglaohui.addModule('widgets.upload', {
	//组件绑定
	bind : function(selector, config) {
		this.selectorCheck(selector);
		this.setAttribute('action', config);
	},
	selectorCheck : function(selector) {
		if ($('selector').attr('type')!='file') {
			throw '绑定的元素不是input[file].';
		}
	},
	setAttribute : function(attr, config) {
		if (!config[attr]) {
			throw attr+'未指定.';
		}
	}
});
kanglaohui.addModule('widgets.dialog', {});*/