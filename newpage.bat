@echo off
setlocal enableextensions disabledelayedexpansion

for /f "tokens=1,* delims=\" %%a in ("%1") do set "page=%%b"

hugo new --kind page %page%
