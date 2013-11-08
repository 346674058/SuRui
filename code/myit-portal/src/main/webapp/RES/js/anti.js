var anti = function () {
	this.a = -1,
	this.b = -1,
	this.c = -1,
	this.d = -1,
	this.e = -1,
	this.f = -1,
	this.g = -1,
	this.h = -1,
	this.i = -1
};
anti.prototype = {
	k : function (b) {
		return document.getElementById(b);
	},
	l : function (b) {
		return document.getElementsByTagName(b);
	},
	m : function (b) {
		return b || window.event;
	},
	n : function (b) {
		var b = this.m(b);
		return b.target || b.srcElement;
	},
	o : function (b, c, d) {
		if (window.addEventListener) {
			b.addEventListener(c, d, false);
		} else {
			b.attachEvent('on' + c, d);
		}
	},
	p : function (b) {
		var c = this.m(b);
		var d = this.n(b);
		if (d.tagName.toLowerCase() != 'a')
			d = d.parentNode;
		if (d.href.indexOf('&ck') != -1)
			return;
		this.v(c);
		this.u();
		this.w(d);
		this.x(d)
	},
	q : function () {
		return new Date().getTime();
	},
	r : function (b) {
		if (this.h == -1)
			this.h = 0;
		this.h++;
	},
	s : function (b) {
		if (b.type == "mousedown")
			this.e = this.q();
		else
			this.e = this.q() - this.e;
	},
	t : function (b) {
		this.c == -1 ? this.c = b.clientX : this.c = this.c;
		this.d == -1 ? this.d = b.clientY : this.d = this.d;
	},
	u : function () {
		if (this.f == -1)
			this.f = this.q();
		this.g = this.q() - this.f;
	},
	v : function (b) {
		this.a = b.clientX;
		this.b = b.clientY;
	},
	w : function (b) {
		this.i = 0;
		var c = /\.php\?(url=)?([0-9a-zA-Z_-]*)\./.exec(b.href);
		c = c[2];
		var e = parseInt(b.getAttribute("mid"));
		var f;
		for (var g = 0; g < (((this.h * e) % 99) + 9); g++) {
			var h = (this.e * g) % c.length;
			this.i += c.charCodeAt(h);
		}
	},
	x : function (b) {
		var c = b.innerHTML;
		b.href += '&ck=' + this.i + '.' + this.h + '.' + this.e + '.' + this.a + '.' + this.b + '.' + this.c + '.' + this.d + '.' + this.g;
		if ((c.match(/(www\.)|(.*@.*)/i) != null) && document.all) {
			c.match(/\<.*\>/i) == null ? b.innerHTML = c : b.innerTEXT = c;
		}
	},
	y : function (b, c, d) {
		var e = b;
		var f = c;
		return function () {
			if (d && d.length) {
				return e.apply(f || {}, d);
			} else {
				return e.apply(f || {}, arguments);
			}
		}
	}
};

var antiRun = function(antiObj, obj) {
	var Dishs = obj.getElementsByTagName('a');
	antiObj.o(obj, 'mouseover', antiObj.y(antiObj.t, antiObj));
	antiObj.o(obj, 'mouseover', antiObj.y(antiObj.u, antiObj));
	for (var i = 0; i < Dishs.length; i++) {
		if (/\.php\?(url=)?([0-9a-zA-Z_-]*)\./.test(Dishs[i].href)) {
			antiObj.o(Dishs[i], 'mousedown', antiObj.y(antiObj.s, antiObj));
			antiObj.o(Dishs[i], 'mouseup', antiObj.y(antiObj.s, antiObj));
			antiObj.o(Dishs[i], 'click', antiObj.y(antiObj.p, antiObj));
			antiObj.o(Dishs[i], 'mouseover', antiObj.y(antiObj.r, antiObj));
		}
	}
};