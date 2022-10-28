#!/bin/bash

git add .
git commit -m "new"
git push
npm version 1.0.57
npm publish
