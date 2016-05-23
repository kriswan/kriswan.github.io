#!/bin/sh

if test $1 = 'test'
then
  hexo clean
  hexo g 
  hexo s
else
  hexo clean
  hexo g && gulp
  hexo deploy
  hexo clean
  echo 'adding files...'
  gaa
  echo 'commiting files...'
  gcam 'commit change files'
  echo 'pushing to remote branch hexo_blog_code...'
  git push origin hexo_blog_code
fi
