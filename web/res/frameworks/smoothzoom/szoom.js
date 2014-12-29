/*
 * Smoothzoom
 * http://kthornbloom.com/smoothzoom
 *
 * Copyright 2014, Kevin Thornbloom
 * Free to use and modify under the MIT license.
 * http://www.opensource.org/licenses/mit-license.php
 */

jQuery.easing['jswing'] = jQuery.easing['swing'];

jQuery.extend( jQuery.easing,
    {
        def: 'easeOutQuad',
        swing: function (x, t, b, c, d) {
            //alert(jQuery.easing.default);
            return jQuery.easing[jQuery.easing.def](x, t, b, c, d);
        },
        easeInQuad: function (x, t, b, c, d) {
            return c*(t/=d)*t + b;
        },
        easeOutQuad: function (x, t, b, c, d) {
            return -c *(t/=d)*(t-2) + b;
        },
        easeInOutQuad: function (x, t, b, c, d) {
            if ((t/=d/2) < 1) return c/2*t*t + b;
            return -c/2 * ((--t)*(t-2) - 1) + b;
        },
        easeInCubic: function (x, t, b, c, d) {
            return c*(t/=d)*t*t + b;
        },
        easeOutCubic: function (x, t, b, c, d) {
            return c*((t=t/d-1)*t*t + 1) + b;
        },
        easeInOutCubic: function (x, t, b, c, d) {
            if ((t/=d/2) < 1) return c/2*t*t*t + b;
            return c/2*((t-=2)*t*t + 2) + b;
        },
        easeInQuart: function (x, t, b, c, d) {
            return c*(t/=d)*t*t*t + b;
        },
        easeOutQuart: function (x, t, b, c, d) {
            return -c * ((t=t/d-1)*t*t*t - 1) + b;
        },
        easeInOutQuart: function (x, t, b, c, d) {
            if ((t/=d/2) < 1) return c/2*t*t*t*t + b;
            return -c/2 * ((t-=2)*t*t*t - 2) + b;
        },
        easeInQuint: function (x, t, b, c, d) {
            return c*(t/=d)*t*t*t*t + b;
        },
        easeOutQuint: function (x, t, b, c, d) {
            return c*((t=t/d-1)*t*t*t*t + 1) + b;
        },
        easeInOutQuint: function (x, t, b, c, d) {
            if ((t/=d/2) < 1) return c/2*t*t*t*t*t + b;
            return c/2*((t-=2)*t*t*t*t + 2) + b;
        },
        easeInSine: function (x, t, b, c, d) {
            return -c * Math.cos(t/d * (Math.PI/2)) + c + b;
        },
        easeOutSine: function (x, t, b, c, d) {
            return c * Math.sin(t/d * (Math.PI/2)) + b;
        },
        easeInOutSine: function (x, t, b, c, d) {
            return -c/2 * (Math.cos(Math.PI*t/d) - 1) + b;
        },
        easeInExpo: function (x, t, b, c, d) {
            return (t==0) ? b : c * Math.pow(2, 10 * (t/d - 1)) + b;
        },
        easeOutExpo: function (x, t, b, c, d) {
            return (t==d) ? b+c : c * (-Math.pow(2, -10 * t/d) + 1) + b;
        },
        easeInOutExpo: function (x, t, b, c, d) {
            if (t==0) return b;
            if (t==d) return b+c;
            if ((t/=d/2) < 1) return c/2 * Math.pow(2, 10 * (t - 1)) + b;
            return c/2 * (-Math.pow(2, -10 * --t) + 2) + b;
        },
        easeInCirc: function (x, t, b, c, d) {
            return -c * (Math.sqrt(1 - (t/=d)*t) - 1) + b;
        },
        easeOutCirc: function (x, t, b, c, d) {
            return c * Math.sqrt(1 - (t=t/d-1)*t) + b;
        },
        easeInOutCirc: function (x, t, b, c, d) {
            if ((t/=d/2) < 1) return -c/2 * (Math.sqrt(1 - t*t) - 1) + b;
            return c/2 * (Math.sqrt(1 - (t-=2)*t) + 1) + b;
        },
        easeInElastic: function (x, t, b, c, d) {
            var s=1.70158;var p=0;var a=c;
            if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
            if (a < Math.abs(c)) { a=c; var s=p/4; }
            else var s = p/(2*Math.PI) * Math.asin (c/a);
            return -(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
        },
        easeOutElastic: function (x, t, b, c, d) {
            var s=1.70158;var p=0;var a=c;
            if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
            if (a < Math.abs(c)) { a=c; var s=p/4; }
            else var s = p/(2*Math.PI) * Math.asin (c/a);
            return a*Math.pow(2,-10*t) * Math.sin( (t*d-s)*(2*Math.PI)/p ) + c + b;
        },
        easeInOutElastic: function (x, t, b, c, d) {
            var s=1.70158;var p=0;var a=c;
            if (t==0) return b;  if ((t/=d/2)==2) return b+c;  if (!p) p=d*(.3*1.5);
            if (a < Math.abs(c)) { a=c; var s=p/4; }
            else var s = p/(2*Math.PI) * Math.asin (c/a);
            if (t < 1) return -.5*(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
            return a*Math.pow(2,-10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )*.5 + c + b;
        },
        easeInBack: function (x, t, b, c, d, s) {
            if (s == undefined) s = 1.70158;
            return c*(t/=d)*t*((s+1)*t - s) + b;
        },
        easeOutBack: function (x, t, b, c, d, s) {
            if (s == undefined) s = 1.70158;
            return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
        },
        easeInOutBack: function (x, t, b, c, d, s) {
            if (s == undefined) s = 1.70158;
            if ((t/=d/2) < 1) return c/2*(t*t*(((s*=(1.525))+1)*t - s)) + b;
            return c/2*((t-=2)*t*(((s*=(1.525))+1)*t + s) + 2) + b;
        },
        easeInBounce: function (x, t, b, c, d) {
            return c - jQuery.easing.easeOutBounce (x, d-t, 0, c, d) + b;
        },
        easeOutBounce: function (x, t, b, c, d) {
            if ((t/=d) < (1/2.75)) {
                return c*(7.5625*t*t) + b;
            } else if (t < (2/2.75)) {
                return c*(7.5625*(t-=(1.5/2.75))*t + .75) + b;
            } else if (t < (2.5/2.75)) {
                return c*(7.5625*(t-=(2.25/2.75))*t + .9375) + b;
            } else {
                return c*(7.5625*(t-=(2.625/2.75))*t + .984375) + b;
            }
        },
        easeInOutBounce: function (x, t, b, c, d) {
            if (t < d/2) return jQuery.easing.easeInBounce (x, t*2, 0, c, d) * .5 + b;
            return jQuery.easing.easeOutBounce (x, t*2-d, 0, c, d) * .5 + c*.5 + b;
        }
    });

(function($) {
    $.fn.extend({
        smoothZoom: function(options) {

            var defaults = {
                zoominSpeed: 800,
                zoomoutSpeed: 400,
                resizeDelay: 400,
                zoominEasing: 'easeOutExpo',
                zoomoutEasing: 'easeOutExpo'
            };

            var options = $.extend(defaults, options);



            // CLICKING AN IMAGE

            $('img[rel="zoom"]').click(function(event) {

                var link = $(this).attr('src'),
                    largeImg = $(this).parent().attr('href'),
                    target = $(this).parent().attr('target'),
                    offset = $(this).offset(),
                    width = $(this).width(),
                    height = $(this).height(),
                    amountScrolled = $(window).scrollTop(),
                    viewportWidth = $(window).width(),
                    viewportHeight = $(window).height();
                // IF THERE IS NO ANCHOR WRAP
                if ((!largeImg) || (largeImg == "#")) {

                    $('body').append("<div id='lightwrap'><img src=" + link + "></div><div id='lightbg'></div><img id='off-screen' src=" + link + ">");
                    $("#off-screen").load(function() {
                        $('#lightwrap img').css({
                            width: width,
                            height: height,
                            top: (offset.top - amountScrolled),
                            left: offset.left
                        });
                        fitWidth();
                        $('#lightbg').fadeIn();
                    });
                    $(this).attr('id', 'lightzoomed');

                    // IF THERE IS AN ANCHOR, AND IT'S AN IMAGE
                } else if (largeImg.match("[jpg|png|gif|JPG|PNG|GIF](\\?.*?)?$")) {
                    $('body').append("<div id='lightwrap'><img src=" + largeImg + "></div><div id='lightbg'></div><img id='off-screen' src=" + largeImg + ">");
                    $("#off-screen").load(function() {
                        $('#lightwrap img').css({
                            width: width,
                            height: height,
                            top: (offset.top - amountScrolled),
                            left: offset.left
                        });
                        fitWidth();
                        $('#lightbg').fadeIn();
                    });
                    $(this).attr('id', 'lightzoomed');

                    // IF THERE IS AN ANCHOR, BUT NOT AN IMAGE
                } else {
                    // SHOULD IT OPEN IN A NEW WINDOW?
                    if (target == '_blank') {
                        window.open(largeImg, '_blank');
                    } else {
                        window.location = largeImg;
                    }
                }
                event.preventDefault();
            });

            // CLOSE MODAL

            $(document.body).on("click", "#lightwrap, #lightbg", function(event) {
                var offset = $("#lightzoomed").offset(),
                    originalWidth = $("#lightzoomed").width(),
                    originalHeight = $("#lightzoomed").height(),
                    amountScrolled = $(window).scrollTop();
                $('#lightbg').fadeOut(500);
                $('#lightwrap img').animate({
                    height: originalHeight,
                    width: originalWidth,
                    top: (offset.top - amountScrolled),
                    left: offset.left,
                    marginTop: '0',
                    marginLeft: '0'
                }, options.zoomoutSpeed, options.zoomoutEasing, function() {
                    $('#lightwrap, #lightbg, #off-screen').remove();
                    $('#lightzoomed').removeAttr('id');

                });
            });

            // DELAY FUNCTION FOR WINDOW RESIZE
            var delay = (function() {
                var timer = 0;
                return function(callback, ms) {
                    clearTimeout(timer);
                    timer = setTimeout(callback, ms);
                };
            })();

            // CHECK WINDOW SIZE EVERY _ MS
            $(window).resize(function() {
                delay(function() {
                    fitWidth();
                }, options.resizeDelay);
            });


            // FIT IMAGE BASED ON HEIGHT
            function fitHeight() {

                var viewportHeight = $(window).height(),
                    viewportWidth = $(window).width(),
                    naturalWidth = $('#off-screen').width(),
                    naturalHeight = $('#off-screen').height(),
                    newHeight = (viewportHeight * 0.95),
                    ratio = (newHeight / naturalHeight),
                    newWidth = (naturalWidth * ratio);
                $('#lightwrap img').show();
                if (newHeight > naturalHeight) {
                    $('#lightwrap img').animate({
                        height: naturalHeight,
                        width: naturalWidth,
                        left: '50%',
                        top: '50%',
                        marginTop: -(naturalHeight / 2),
                        marginLeft: -(naturalWidth / 2)
                    }, options.zoominSpeed, options.zoominEasing);
                } else {
                    if (newWidth > viewportWidth) {
                        fitWidth();
                    } else {
                        $('#lightwrap img').animate({
                            height: newHeight,
                            width: newWidth,
                            left: '50%',
                            top: '2.5%',
                            marginTop: '0',
                            marginLeft: -(newWidth / 2)
                        }, options.zoominSpeed, options.zoominEasing);
                    }
                }
            }

            // FIT IMAGE BASED ON WIDTH
            function fitWidth() {

                var naturalWidth = $('#off-screen').width(),
                    naturalHeight = $('#off-screen').height(),
                    viewportWidth = $(window).width(),
                    viewportHeight = $(window).height(),
                    newWidth = (viewportWidth * 0.95),
                    ratio = (newWidth / naturalWidth),
                    newHeight = (naturalHeight * ratio);
                $('#lightwrap img').show();
                if (newHeight > naturalHeight) {
                    if (naturalHeight > viewportHeight) {
                        fitHeight();
                    } else {
                        $('#lightwrap img').animate({
                            height: naturalHeight,
                            width: naturalWidth,
                            top: '50%',
                            left: '50%',
                            marginTop: -(naturalHeight / 2),
                            marginLeft: -(naturalWidth / 2)
                        }, options.zoominSpeed, options.zoominEasing);
                    }
                } else {
                    if (newHeight > viewportHeight) {
                        fitHeight();
                    } else {
                        $('#lightwrap img').animate({
                            height: newHeight,
                            width: newWidth,
                            top: '50%',
                            left: '2.5%',
                            marginTop: -(newHeight / 2),
                            marginLeft: '0'
                        }, options.zoominSpeed, options.zoominEasing);
                    }
                }
            }


        }
    });
})(jQuery);
