#!/usr/bin/env bash
search(){
    files=$(ls $1)
    for i in $files
    do
      if [ "$2" = "$i" ]
      then
        return 0
      fi
    done
    echo "$2 not present"
    return 1
}

commandExecutor(){
  for command in "$@"
  do
    if ! $command
    then
      return 1
    fi
  done
  return 0
}

ret (){
  return $1
}
