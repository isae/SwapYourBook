/**
 * Created by root on 1/12/15.
 */
function loadTab(elem,e) {
    e.preventDefault();
    var $this = elem,
        targ = $this.attr('data-target'),
        loadurl = $this.attr('href');

    $.ajax({
        type: "POST",
        async:false,
        url: loadurl,
        success: function (data) {
            $(targ).html(data);
        }
    });

    $this.tab('show');
}

function prepareForWork() {
    var zoomable = $('.zoomable');
    zoomable.smoothZoom();
    zoomable.click(function (e) {
        e.stopPropagation();
    });
    $(".clickableBook").click(function (e) {
        var $this = $(this);
        var bookID = $this.find(".offerID").text();
        $(location).attr("href", "./book/editBookForm?userOfferID=" + bookID);
    });

    $("#openBookAddFormButton").click(function (e) {
        $("#bookAddPane").collapse('toggle');
    });

    $('#authorName').autocomplete({
        serviceUrl: 'user/addOffer/authorAutocomplete',
        paramName: "requestedString",
        maxHeight: 400,
        transformResult: function (response) {

            return {
                //must convert json to javascript object before process
                suggestions: $.map($.parseJSON(response), function (item) {
                    return { value: item.tagName, data: item.id };
                })

            };

        }
    });

    $('#bookTitle').autocomplete({
        serviceUrl: 'user/addOffer/titleAutocomplete',
        paramName: "requestedString",
        maxHeight: 400,
        transformResult: function (response) {

            return {
                //must convert json to javascript object before process
                suggestions: $.map($.parseJSON(response), function (item) {
                    return { value: item.tagName, data: item.id };
                })

            };

        }
    });
}


$(document).ready(function () {
    $("#myOffersLink").click(function (e) {
        loadTab($(this),e);
        prepareForWork();
        $("#submitBookAddFormButton").click(function (e) {
            e.preventDefault();
            $("#bookAddForm").ajaxForm({
                success: function (data) {
                },
                dataType: "text"
            }).submit();
            $("#myOffersLink").trigger('click');
            prepareForWork();
        });
    });

    $("#myWishesLink").click(function (e) {
        loadTab($(this),e);

        $("#addUserWishFormButton").click(function (e) {
            $("#bookWishAddPane").collapse('toggle');
        });

        $("#submitBookWishAddFormButton").click(function (e) {
            e.preventDefault();
            $("#bookWishAddForm").ajaxForm({
                async: false,
                success: function (data) {
                    $("#myWishesLink").trigger("click");
                },
                dataType: "text"
            }).submit();
        });

        $(".clickableBook").click(function (e) {
            var $this = $(this);
            var id = $this.find(".userWishID").text();
            var div1 = $this.find(".bookTitle"), div2 = $this.find(".bookAuthor");
            var text1 = div1.text(), text2 = div2.text();
            $("#userWishID").val(id);
            $("#formAuthorName").val(text2);
            $("#formBookTitle").val(text1);
            $('#editUserWishModal').modal('show');
        });

        $("#editUserWishModalSubmitButton").click(function (e) {
            e.preventDefault();
            $("#editUserWishForm").ajaxForm({
                async: false,
                success: function (data) {
                    $("#myWishesLink").trigger("click");
                },
                dataType: "text"
            }).submit();
        });

        $("#deleteUserWishButton").click(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                async: false,
                url: "./user/deleteUserWish",
                data: {
                    userWishID: $("#userWishID").val()
                },

                success: function (data) {
                    $("#myWishesLink").trigger("click");
                }
            });
        });

        $('#authorName').autocomplete({
            serviceUrl: 'user/addOffer/authorAutocomplete',
            paramName: "requestedString",
            maxHeight: 400,
            transformResult: function (response) {

                return {
                    //must convert json to javascript object before process
                    suggestions: $.map($.parseJSON(response), function (item) {
                        return { value: item.tagName, data: item.id };
                    })

                };

            }
        });

        $('#bookTitle').autocomplete({
            serviceUrl: 'user/addOffer/titleAutocomplete',
            paramName: "requestedString",
            maxHeight: 400,
            transformResult: function (response) {

                return {
                    //must convert json to javascript object before process
                    suggestions: $.map($.parseJSON(response), function (item) {
                        return { value: item.tagName, data: item.id };
                    })

                };

            }
        });

        $('#formAuthorName').autocomplete({
            serviceUrl: 'user/addOffer/authorAutocomplete',
            paramName: "requestedString",
            maxHeight: 400,
            transformResult: function (response) {

                return {
                    //must convert json to javascript object before process
                    suggestions: $.map($.parseJSON(response), function (item) {
                        return { value: item.tagName, data: item.id };
                    })

                };

            }
        });

        $('#formBookTitle').autocomplete({
            serviceUrl: 'user/addOffer/titleAutocomplete',
            paramName: "requestedString",
            maxHeight: 400,
            transformResult: function (response) {

                return {
                    //must convert json to javascript object before process
                    suggestions: $.map($.parseJSON(response), function (item) {
                        return { value: item.tagName, data: item.id };
                    })

                };

            }
        });
    });

    $("#mySettingsLink").click(function (e) {
        loadTab($(this),e);
        $("#editUserButton").click(function (e) {
            e.preventDefault();
            $("#userEditForm").ajaxForm({
                async: false,
                success: function (data) {
                    $.notify("Успешно!", "success");
                },
                error:function (data) {
                    $.notify("Ошибка!", "error");
                },
                dataType: "text"
            }).submit();
        });
        $("#changePasswordButton").click(function (e) {
            e.preventDefault();
            $("#changePasswordForm").ajaxForm({
                async: false,
                success: function (data) {
                    var response = JSON.parse(data);
                    $.notify(response.value, response.key);
                },
                dataType: "text"
            }).submit();
        });

        $('#userCity').autocomplete({
            serviceUrl: 'user/addOffer/cityAutocomplete',
            paramName: "requestedString",
            maxCount: 10,
            transformResult: function (response) {

                return {
                    //must convert json to javascript object before process
                    suggestions: $.map($.parseJSON(response), function (item) {
                        return { value: item.tagName, data: item.id };
                    })

                };

            }
        });
    });


    $("#myOffersLink").trigger('click');
});