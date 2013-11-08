var _SILDE = {
		'i' : 0,
		't' : true,
		'start' : function(a, b, c) {
			$(a).hover(function() {
				_SILDE.t = false;
			}, function() {
				_SILDE.t = true;
			});
			if (typeof c == 'undefined') {
				c = $(a).find(b).length;
			}
			if ($(a + ' .list').length == 0) {
				$(a).append('<ul class="list"></ul>');
				for ( var i = 0; i < c; i++) {
					$(a + ' .list').append(
							'<li onmouseover="_SILDE.tab(\'' + a + '\',' + i
									+ ',' + c + ')" class="slideList_' + i
									+ '"></li>');
				}
			}
			for ( var i = 0; i < c; i++) {
				$(a).find(b).eq(i).addClass('slide_' + i);
			}
			if (_SILDE.t == true) {
				if (_SILDE.i >= c) {
					_SILDE.i = 0;
					setTimeout('_SILDE.start("' + a + '","' + b + '","' + c
							+ '")', 3000);
					_SILDE.tab(a, _SILDE.i, c);
					_SILDE.i = 1;
				} else {
					setTimeout('_SILDE.start("' + a + '","' + b + '","' + c
							+ '")', 3000);
					_SILDE.tab(a, _SILDE.i, c);
					_SILDE.i = _SILDE.i + 1;
				}
			} else {
				setTimeout('_SILDE.start("' + a + '","' + b + '","' + c + '")',
						1000);
			}
		},
		'tab' : function(a, b, c) {
			try {
				for ( var i = 0; i < c; i++) {
					if (i != b) {
						$(a + " .slideList_" + i).removeClass('on');
						$(a + " .slide_" + i).hide();
					}
				}
				$(a + " .slideList_" + b).addClass('on');
				
				//TODO 无效
				$(a + " .slide_" + b).fadeIn(1000);
				
				//$(a + " .slide_" + b).show();
				_SILDE.i = b;
			} catch (f) {
			}
		}
	};