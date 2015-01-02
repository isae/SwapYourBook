<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <script src="<s:url value="/res/js/jquery-1.11.1.js" />" type="text/javascript"></script>
    <script src="<s:url value="/res/js/jquery.autocomplete.js" />"></script>
    <script src="<s:url value="/res/frameworks/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
</head>
<body>
<h2>Spring MVC + jQuery + Autocomplete example</h2>

<div>
    <input type="text"  id="w-input-search" value="">
	<span>
	  <button id="button-id" type="button">Search</button>
	</span>
</div>

<script>
    $(document).ready(function() {

        $('#w-input-search').autocomplete({
            serviceUrl: 'test/getTags',
            paramName: "tagName",
            delimiter: ",",
            transformResult: function(response) {

                return {
                    //must convert json to javascript object before process
                    suggestions: $.map($.parseJSON(response), function(item) {
                        return { value: item.tagName, data: item.id };
                    })

                };

            }

        });

    });
</script>

</body>
</html>
