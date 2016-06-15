{% if theme.swiftype_key %}
  {% include 'search/swiftype.swig' %}
{% elseif theme.tinysou_Key %}
  {% include 'search/tinysou.swig' %}
{% elseif config.algolia.applicationID %}
  {% include 'search/algolia.swig' %}
{% endif %}
