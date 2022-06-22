(function($) {
    $.fn.insertIconGroup = function(id, options) {
        // 默认的图标和事件
        var defaultCallback = function() {
                console.log('testCallback');
            },
            defaultOptions = {
                top: 'bottom',
                left: 'center',
                icons: [{
                    type: 'icon',
                    content: 'glyphicon-thumbs-up'
                }, {
                    type: 'text',
                    content: 'glyphicon-thumbs-down'
                }],
                callbacks: [null, defaultCallback]
            };
        var option = $.extend({}, defaultOptions, options || {});

        var height = this.height();
        var bottom = option.top === 'top' ? (15 + height) : 15;

        var wrapper = $('<div id=' + id + ' class=g-icon-group style=position:relative;text-align:' + option.left + ';bottom:' + bottom + 'px; />');
        var wrapperDiv = $('<div class="btn-group" />');
        wrapper.append(wrapperDiv);

        var icons = option.icons,
            callbacks = option.callbacks;
        for (var i = 0, len = icons.length; i < len; i++) {
            var innerDiv = $('<button type="button" class="btn btn-default" />'),
                icon = icons[i];
            var iconDiv;
            if (icon.type === 'icon') {
                iconDiv = $('<span class="glyphicon ' + icon.content + '">' + '</span>');
            } else {
                iconDiv = $('<span>' + icon.content + '</span>');
            }

            (function(i) {
                var callback = callbacks[i];
                innerDiv.bind('click', function() {
                    if (typeof(callback) === 'function') {
                        callback();
                    }
                });
            })(i);

            innerDiv.append(iconDiv);
            wrapperDiv.append(innerDiv);
        }

        return this.append(wrapper);
    };

    $.fn.removeAllIconGroups = function() {
        $('.g-icon-group', this).remove();
    }

    $.fn.showIconGroups = function() {
        $('.g-icon-group', this).show();
    }

    $.fn.hideIconGroups = function() {
        $('.g-icon-group', this).hide();
    }
})(jQuery);
