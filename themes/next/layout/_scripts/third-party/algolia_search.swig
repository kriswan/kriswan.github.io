
<script src="//cdn.jsdelivr.net/algoliasearch/3/algoliasearch.min.js"></script>
<script src="//cdn.jsdelivr.net/autocomplete.js/0/autocomplete.min.js"></script>
<script>
  var client = algoliasearch("J5OWVCC0MZ", "d73585bd198eaf7155b7089f5b8bd06a")
  var index = client.initIndex('hexo_search');
  autocomplete('#search-input', {hint: false}, [
    {
      source: autocomplete.sources.hits(index, {hitsPerPage: 10}),
      displayKey: 'title',
      templates: {
        suggestion: function(suggestion) {
            var title = suggestion._highlightResult.title.value
            var tag = suggestion._highlightResult.tags[0].name.value
            var slug = suggestion._highlightResult.slug.value
            title = title.replace("<em class=\"highlight\">","").replace("</em>","")
            tag = tag.replace("<em class=\"highlight\">","").replace("</em>","")
            slug = slug.replace("<em class=\"highlight\">","").replace("</em>","")
          return title + " | <b><font color=\"red\">" + tag + "</font></b>  |  <b>" + slug + "</b>";
        }
      }
    }
  ]).on('autocomplete:selected', function(event, suggestion, dataset) {
    var str = suggestion._highlightResult.path.value
    str = str.replace("<em class=\"highlight\">","")
    str = str.replace("</em>","")
    window.open("http://" + window.location.host + "/" + str, '_self');
  });
</script>


