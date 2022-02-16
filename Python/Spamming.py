import time
import pyautogui

time.sleep(5)
f = open("spam.txt")
for each_line in f:
        pyautogui.typewrite(each_line)
        pyautogui.press('enter')



