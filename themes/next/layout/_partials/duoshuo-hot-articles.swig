{# 多说热评文章 #}
{% if (theme.duoshuo_hotartical and page.title) %}
  <br/>
  <hr />
  <p>热评文章</p>
  <div class="ds-top-threads" data-range="daily" data-num-items="3"></div>
{% endif %}
