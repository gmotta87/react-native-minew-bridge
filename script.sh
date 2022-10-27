#!/bin/bash

git add .
git commit -m "new"
git push
npm version 1.0.36
npm publish
