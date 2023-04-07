from Mobile import Mobile
from DisplayFeatures import DisplayFeatures
from ScreenResolution import ScreenResolution
from MobileService import MobileService

resolution = ScreenResolution(750, 1334)
dfeatures = DisplayFeatures("4.7", resolution)
mobile = Mobile(2015001, "Apple", "iPhone 6s", dfeatures)

mService = MobileService()

width = mService.getMobileScreenWidth(mobile)
print("Apple iPhone 6s Screen Width = ", width)

mobile2 = Mobile(2015001, "Apple", "iPhone 6s", None)
width2 = mService.getMobileScreenWidth(mobile2)
print("Apple iPhone 16s Screen Width = ", width2)
