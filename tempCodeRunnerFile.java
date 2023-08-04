  for(int i = 0 ;  i<rows ;i++){
            for(int j = 0 ; j< col ; j++){
                 keypad[i][j] = num;
                num = (num + 1) % 10;
            }
        }